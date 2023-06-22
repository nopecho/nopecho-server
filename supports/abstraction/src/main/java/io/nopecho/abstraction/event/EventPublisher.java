package io.nopecho.abstraction.event;

public interface EventPublisher {

    void publish(DomainEvent event);
}
