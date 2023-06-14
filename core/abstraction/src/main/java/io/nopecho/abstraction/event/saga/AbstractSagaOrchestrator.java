package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.event.EventPublisher;

public abstract class AbstractSagaOrchestrator implements SagaOrchestrator {
    protected final EventTransactionManager transactionManager;
    protected final EventPublisher eventPublisher;

    protected AbstractSagaOrchestrator(EventTransactionManager transactionManager, EventPublisher eventPublisher) {
        this.transactionManager = transactionManager;
        this.eventPublisher = eventPublisher;
    }
}
