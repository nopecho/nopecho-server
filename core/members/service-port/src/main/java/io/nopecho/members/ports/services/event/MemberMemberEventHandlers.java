package io.nopecho.members.ports.services.event;

import io.nopecho.event.CompositeEventHandler;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventHandler;
import io.nopecho.members.ports.in.event.MemberEventDispatcher;

public class MemberMemberEventHandlers extends CompositeEventHandler implements MemberEventDispatcher {

    public MemberMemberEventHandlers(DomainEventHandler<?>... handlers) {
        super(handlers);
    }

    @Override
    public void dispatch(DomainEvent event) {
        handle(event.getPayload());
    }
}
