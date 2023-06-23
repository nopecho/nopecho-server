package io.nopecho.event.saga;

import io.nopecho.event.DomainEvent;

public interface SagaOrchestrator {
    boolean isSupport(DomainEvent event);

    void orchestration(DomainEvent event);
}