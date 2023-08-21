package io.nopecho.event;


public interface DomainEventListener {

    void receive(DomainEvent event);
}
