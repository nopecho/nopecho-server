package io.nopecho.domainevents.ports.out;

import io.nopecho.event.DomainEvent;

public interface SaveDomainEventPort {
    void save(DomainEvent event);
}
