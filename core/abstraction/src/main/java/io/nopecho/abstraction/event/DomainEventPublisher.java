package io.nopecho.abstraction.event;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
