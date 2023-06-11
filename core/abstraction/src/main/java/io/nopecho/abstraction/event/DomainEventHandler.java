package io.nopecho.abstraction.event;


public interface DomainEventHandler {

    boolean canHandle(DomainEvent domainEvent);

    void handle(DomainEvent domainEvent);
}
