package io.nopecho.event.saga;

import io.nopecho.command.VoidCommand;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.VoidEvent;

public final class VoidTransition implements EventTransition<VoidEvent, VoidCommand> {

    @Override
    public boolean isSupport(DomainEvent event) {
        return event.isType(VoidEvent.class);
    }

    @Override
    public VoidEvent getEventPayload(DomainEvent event) {
        return null;
    }

    @Override
    public VoidCommand apply(DomainEvent event) {
        return new VoidCommand();
    }
}
