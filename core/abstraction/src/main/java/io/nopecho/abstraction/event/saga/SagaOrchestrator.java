package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.event.DomainEvent;

public interface SagaOrchestrator {
    void onSuccess(DomainEvent event);

    void onFail(DomainEvent event);
}