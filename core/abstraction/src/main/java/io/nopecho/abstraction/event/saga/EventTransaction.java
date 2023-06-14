package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.EventPayload;

public interface EventTransaction<COMMIT extends EventPayload, COMPENSATION extends EventPayload> {
    boolean isSupport(DomainEvent event);

    COMMIT getCommitEvent(DomainEvent event);

    COMPENSATION getCompensationEvent(DomainEvent event);
}