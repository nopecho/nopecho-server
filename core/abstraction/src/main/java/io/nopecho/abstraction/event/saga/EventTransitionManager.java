package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.event.DomainEvent;

public interface EventTransitionManager {
    Command nextTransition(DomainEvent event);
}
