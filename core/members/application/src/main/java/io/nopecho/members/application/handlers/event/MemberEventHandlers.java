package io.nopecho.members.application.handlers.event;

import io.nopecho.event.CompositeEventHandler;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventHandler;
import io.nopecho.members.application.usecase.event.MemberEventDispatcher;

public class MemberEventHandlers extends CompositeEventHandler implements MemberEventDispatcher {

    public MemberEventHandlers(DomainEventHandler<?>... handlers) {
        super(handlers);
    }

    @Override
    public void dispatch(DomainEvent event) {
        handle(event.getPayload());
    }
}
