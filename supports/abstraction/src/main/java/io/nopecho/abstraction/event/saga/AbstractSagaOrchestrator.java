package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.event.EventPayload;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSagaOrchestrator implements SagaOrchestrator {
    protected final Set<Class<? extends EventPayload>> supportedEvents = new HashSet<>();

    public void subscription(Class<? extends EventPayload> event) {
        this.supportedEvents.add(event);
    }
}
