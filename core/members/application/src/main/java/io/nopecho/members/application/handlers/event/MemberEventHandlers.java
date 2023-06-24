package io.nopecho.members.application.handlers.event;

import io.nopecho.event.CompositeEventHandler;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventHandler;
import io.nopecho.members.application.port.in.event.EventHandleUseCase;

public class MemberEventHandlers extends CompositeEventHandler implements EventHandleUseCase {

    public MemberEventHandlers(DomainEventHandler<?>... handlers) {
        super(handlers);
    }

    @Override
    public void handle(DomainEvent event) {
        handle(event.getPayload());
    }
}
