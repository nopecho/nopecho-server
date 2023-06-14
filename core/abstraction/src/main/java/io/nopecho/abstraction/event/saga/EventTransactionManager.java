package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.event.DomainEvent;

public interface EventTransactionManager {
    DomainEvent commit(DomainEvent event);

    DomainEvent rollback(DomainEvent event);
}
