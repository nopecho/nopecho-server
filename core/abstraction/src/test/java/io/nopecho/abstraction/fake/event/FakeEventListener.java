package io.nopecho.abstraction.fake.event;

import io.nopecho.abstraction.event.AbstractEventListener;
import io.nopecho.abstraction.event.CompositeEventHandler;
import io.nopecho.abstraction.event.DomainEvent;

public class FakeEventListener extends AbstractEventListener {

    public FakeEventListener(CompositeEventHandler handler) {
        super(handler);
    }

    @Override
    public void receive(DomainEvent event) {
        super.handler.handle(event);
    }
}
