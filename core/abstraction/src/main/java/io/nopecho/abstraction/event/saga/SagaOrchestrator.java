package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.event.DomainEvent;

public interface SagaOrchestrator {
    boolean isSupport(DomainEvent event);

    void orchestration(DomainEvent event);
}