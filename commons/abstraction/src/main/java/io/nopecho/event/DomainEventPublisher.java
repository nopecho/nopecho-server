package io.nopecho.event;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}
