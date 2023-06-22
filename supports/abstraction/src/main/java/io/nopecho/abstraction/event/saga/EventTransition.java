package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.EventPayload;

public interface EventTransition<T extends EventPayload, R extends Command> {
    boolean isSupport(DomainEvent event);

    T getEventPayload(DomainEvent event);

    R apply(DomainEvent event);
}