package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.VoidEvent;

public final class VoidTransaction implements EventTransaction<VoidEvent, VoidEvent> {

    @Override
    public boolean isSupport(DomainEvent event) {
        return false;
    }

    @Override
    public VoidEvent getCommitEvent(DomainEvent event) {
        return new VoidEvent();
    }

    @Override
    public VoidEvent getCompensationEvent(DomainEvent event) {
        return new VoidEvent();
    }
}
