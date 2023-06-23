package io.nopecho.eventstore.application.port.out;

import io.nopecho.event.DomainEvent;

public interface SaveDomainEventPort {
    void save(DomainEvent event);
}
