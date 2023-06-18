package io.nopecho.abstraction.event.saga;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.DomainEventHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class SagaEventHandler implements DomainEventHandler {

    private final List<DomainEventHandler> handlers;

    protected SagaEventHandler(DomainEventHandler... handler) {
        this.handlers = Collections.unmodifiableList(Arrays.asList(handler));
    }

    @Override
    public boolean canHandle(DomainEvent domainEvent) {
        return this.handlers.stream()
                .anyMatch(h -> h.canHandle(domainEvent));
    }

    @Override
    public Command handle(DomainEvent domainEvent) {
        return handleIfSupport(domainEvent);
    }

    private Command handleIfSupport(DomainEvent event) {
        if (canHandle(event)) {
            return handleOrThrow(event);
        }
        throw new RuntimeException(
                String.format("not found supported events from this handlers. handler: %s, event: %s", this.getClass().getTypeName(), getEventType(event))
        );
    }

    private Command handleOrThrow(DomainEvent event) {
        DomainEventHandler handler = findHandlerOrThrow(event);
        try {
            return handler.handle(event);
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
