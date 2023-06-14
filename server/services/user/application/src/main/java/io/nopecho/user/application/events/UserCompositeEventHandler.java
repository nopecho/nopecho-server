package io.nopecho.user.application.events;

import io.nopecho.abstraction.event.CompositeEventHandler;
import io.nopecho.abstraction.event.DomainEventHandler;

public class UserCompositeEventHandler extends CompositeEventHandler {

    public UserCompositeEventHandler(DomainEventHandler... handler) {
        super(handler);
    }
}