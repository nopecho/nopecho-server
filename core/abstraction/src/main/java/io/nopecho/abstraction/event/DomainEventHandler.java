package io.nopecho.abstraction.event;


import io.nopecho.abstraction.command.Command;

public interface DomainEventHandler {

    boolean canHandle(DomainEvent domainEvent);

    Command handle(DomainEvent domainEvent);
}
