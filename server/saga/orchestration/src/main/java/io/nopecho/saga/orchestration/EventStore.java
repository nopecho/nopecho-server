package io.nopecho.saga.orchestration;

import io.nopecho.abstraction.event.DomainEvent;

public interface EventStore {

    void store(DomainEvent event);
}