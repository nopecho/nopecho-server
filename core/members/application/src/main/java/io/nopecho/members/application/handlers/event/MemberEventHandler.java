package io.nopecho.members.application.handlers.event;

import io.nopecho.event.CompositeEventHandler;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventHandler;
import io.nopecho.members.application.port.in.event.EventHandleUseCase;

public class MemberEventHandler extends CompositeEventHandler implements EventHandleUseCase {

    public MemberEventHandler(DomainEventHandler<?>... handlers) {
        super(handlers);
    }

    @Override
    public void handle(DomainEvent event) {
        handle(event.getPayload());
    }
}
