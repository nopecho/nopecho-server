package io.nopecho.abstraction.event;


import java.util.*;

public abstract class CompositeEventHandler implements DomainEventHandler {

    private final Set<Class<? extends EventPayload>> supportedEventTypes = new HashSet<>();
    private final List<DomainEventHandler> handlers;

    protected CompositeEventHandler(DomainEventHandler... handler) {
        this.handlers = Collections.unmodifiableList(Arrays.asList(handler));
    }

    public void subscribe(Class<? extends EventPayload> eventType) {
        this.supportedEventTypes.add(eventType);
    }

    @Override
    public boolean canHandle(DomainEvent domainEvent) {
        return this.supportedEventTypes.stream()
                .anyMatch(domainEvent::isType);
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        handleIfSupport(domainEvent);
    }

    private void handleIfSupport(DomainEvent event) {
        if (canHandle(event)) {
            handleOrThrow(event);
            return;
        }
        throw new RuntimeException(
                String.format("not found supported events from this handlers. handler: %s, event: %s", this.getClass().getTypeName(), getEventType(event))
        );
    }

    private void handleOrThrow(DomainEvent event) {
        DomainEventHandler handler = findHandlerOrThrow(event);
        try {
            handler.handle(event);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("error from [%s]. message: %s", getEventType(event), e.getMessage())
            );
        }
    }

    private DomainEventHandler findHandlerOrThrow(DomainEvent event) {
        return this.handlers.stream()
                .filter(h -> h.canHandle(event))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("not found supported handlers to this EventType: %s", getEventType(event)))
                );
    }

    private String getEventType(DomainEvent event) {
        return event.getType();
    }
}
