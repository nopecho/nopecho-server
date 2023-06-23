package io.nopecho.event.saga;

import io.nopecho.command.Command;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.EventPayload;

public interface EventTransition<T extends EventPayload, R extends Command> {
    boolean isSupport(DomainEvent event);

    T getEventPayload(DomainEvent event);

    R apply(DomainEvent event);
}