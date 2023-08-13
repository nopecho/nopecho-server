package io.nopecho.commons.aop;

import io.nopecho.event.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class EventPublishAop {

    private final DomainEventPublisher eventPublisher;

    @Around("@annotation(io.nopecho.commons.aop.EventPublish)")
    public Object eventPublish(final ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object eventPayload = joinPoint.proceed();
            eventPublisher.publish(DomainEvent.of(eventPayload));

            return eventPayload;
        } catch (Exception e) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            EventPublish annotation = method.getAnnotation(EventPublish.class);
            if (isPass(annotation)) {
                throw e;
            }

            Object command = joinPoint.getArgs()[0];
            Object eventPayload = getCompensationEvent(annotation, command);
            eventPublisher.publish(DomainEvent.of(eventPayload));
            throw e;
        }
    }

    Object getCompensationEvent(EventPublish annotation, Object command) {
        Class<? extends EventPayload> type = annotation.compensationType();
        return CompensationEvent.of(type.getTypeName(), command);
    }

    private boolean isPass(EventPublish annotation) {
        return isEnableCompensation(annotation)
                && isVoidCompensation(annotation);
    }

    private boolean isEnableCompensation(EventPublish annotation) {
        return !annotation.compensation();
    }

    private boolean isVoidCompensation(EventPublish annotation) {
        return annotation.compensationType().isInstance(VoidEvent.class);
    }
}
