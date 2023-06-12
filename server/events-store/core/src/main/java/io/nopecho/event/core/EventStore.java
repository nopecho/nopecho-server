package io.nopecho.event.core;

import io.nopecho.abstraction.event.DomainEvent;

public interface EventStore {

    void store(DomainEvent event);
}
