package io.nopecho.event;

import io.nopecho.abstraction.event.DomainEvent;

public interface EventStore {

    void store(DomainEvent event);
}
