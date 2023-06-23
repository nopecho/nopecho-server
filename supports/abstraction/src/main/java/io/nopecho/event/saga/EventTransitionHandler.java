package io.nopecho.event.saga;

import io.nopecho.command.Command;
import io.nopecho.event.DomainEvent;

public interface EventTransitionHandler {
    Command nextTransition(DomainEvent event);
}
