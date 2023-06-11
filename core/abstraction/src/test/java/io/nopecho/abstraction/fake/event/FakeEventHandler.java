package io.nopecho.abstraction.fake.event;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.DomainEventHandler;

public class FakeEventHandler implements DomainEventHandler {

    public boolean isHandle = false;
    private DomainEvent supportedEvent;

    public FakeEventHandler(DomainEvent supportedEvent) {
        this.supportedEvent = supportedEvent;
    }

    public static FakeEventHandler supportEvent(DomainEvent domainEvent) {
        return new FakeEventHandler(domainEvent);
    }

    @Override
    public boolean canHandle(DomainEvent domainEvent) {
        return domainEvent.isType(FakeEvent.class);
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        isHandle = true;
    }
}
