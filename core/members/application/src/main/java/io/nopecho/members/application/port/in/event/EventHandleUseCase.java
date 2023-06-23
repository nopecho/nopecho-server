package io.nopecho.members.application.port.in.event;

import io.nopecho.event.DomainEvent;

public interface EventHandleUseCase {

    void handle(DomainEvent event);
}
