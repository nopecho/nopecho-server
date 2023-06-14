package io.nopecho.abstraction.event;

public abstract class AbstractEventListener implements DomainEventListener {

    protected final CompositeEventHandler handler;

    protected AbstractEventListener(CompositeEventHandler handler) {
        this.handler = handler;
    }

    @Override
    abstract public void receive(DomainEvent event);
}
