package io.nopecho.eventstore.application.port.in;

import io.nopecho.event.DomainEvent;

public interface StoreDomainEventUseCase {
    void store(DomainEvent event);
}
