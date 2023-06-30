package io.nopecho.springevents.ports.in;

import io.nopecho.event.DomainEvent;

public interface StoreDomainEventUseCase {
    void store(DomainEvent event);
}
