package io.nopecho.commons.aop;

import io.nopecho.event.EventPayload;
import io.nopecho.event.VoidEvent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventPublish {

    boolean compensation() default false;

    Class<? extends EventPayload> compensationType() default VoidEvent.class;
}
