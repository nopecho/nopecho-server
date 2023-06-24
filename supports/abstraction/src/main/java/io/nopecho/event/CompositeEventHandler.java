package io.nopecho.event;

import java.util.Set;

public abstract class CompositeEventHandler implements DomainEventHandler<EventPayload> {

    private final Set<DomainEventHandler<?>> handlers;

    protected CompositeEventHandler(DomainEventHandler<?>... handlers) {
        this.handlers = Set.of(handlers);
    }

    @Override
    public boolean canHandle(EventPayload event) {
        return this.handlers.stream()
                .anyMatch(h -> h.canHandle(event));
    }

    @Override
    public void handle(EventPayload event) {
        if (canHandle(event)) {
            findAndHandle(event);
        }
    }

    private void findAndHandle(EventPayload event) {
        DomainEventHandler handler = findHandler(event);
        handler.handle(event);
    }

    private DomainEventHandler findHandler(EventPayload event) {
        return this.handlers.stream()
                .filter(h -> h.canHandle(event))
                .findFirst()
                .orElse(new VoidEventHandler());
    }
}
