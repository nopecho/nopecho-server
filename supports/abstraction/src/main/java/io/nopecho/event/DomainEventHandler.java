package io.nopecho.event;

public interface DomainEventHandler<T extends EventPayload> {

    boolean canHandle(EventPayload event);

    void handle(T event);
}
