package io.nopecho.domainevents.application.usecase;

import io.nopecho.event.DomainEvent;

public interface StoreDomainEventUseCase {
    void store(DomainEvent event);
}
