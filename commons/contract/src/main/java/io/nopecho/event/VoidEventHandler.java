package io.nopecho.event;

public final class VoidEventHandler implements DomainEventHandler<EventPayload> {
    @Override
    public boolean canHandle(EventPayload event) {
        return false;
    }

    @Override
    public void handle(EventPayload event) {
    }
}
