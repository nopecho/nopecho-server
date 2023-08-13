package io.nopecho.domainevents.application.ports;

import io.nopecho.event.DomainEvent;

public interface SaveDomainEventPort {
    void save(DomainEvent event);
}
