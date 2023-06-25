package io.nopecho.aop;

import io.nopecho.event.CompensationEvent;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventPublisher;
import io.nopecho.event.EventPayload;
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

    @Around("@annotation(io.nopecho.aop.EventPublish)")
    public Object eventPublish(final ProceedingJoinPoint joinPoint) throws Throwable {
        Object eventPayload = null;
        try {
            eventPayload = joinPoint.proceed();

            eventPublisher.publish(DomainEvent.of(eventPayload));
            return eventPayload;
        } catch (Exception e) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            EventPublish annotation = method.getAnnotation(EventPublish.class);
            if (!annotation.compensation()) {
                throw e;
            }

            Object command = joinPoint.getArgs()[0];
            eventPayload = getCompensationEvent(annotation, command);
            eventPublisher.publish(DomainEvent.of(eventPayload));
            throw e;
        }
    }

    Object getCompensationEvent(EventPublish annotation, Object command) {
        Class<? extends EventPayload> type = annotation.compensationType();
        return CompensationEvent.of(type.getTypeName(), command);
    }
}
