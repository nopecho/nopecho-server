package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.command.VoidCommand;
import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.VoidEvent;

public final class VoidTransition implements EventTransition<VoidEvent, VoidCommand> {

    @Override
    public boolean isSupport(DomainEvent event) {
        return event.isType(VoidEvent.class);
    }

    @Override
    public VoidEvent get(DomainEvent event) {
        return null;
    }

    @Override
    public VoidCommand associateWith(DomainEvent event) {
        return new VoidCommand();
    }
}
