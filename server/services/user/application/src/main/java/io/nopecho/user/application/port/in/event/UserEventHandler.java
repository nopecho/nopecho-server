package io.nopecho.user.application.port.in.event;

import io.nopecho.abstraction.event.CompositeEventHandler;
import io.nopecho.abstraction.event.DomainEventHandler;

public class UserEventHandler extends CompositeEventHandler {

    public UserEventHandler(DomainEventHandler... handler) {
        super(handler);
    }
}