package io.nopecho.abstraction.event;


public interface DomainEventListener {

    void receive(DomainEvent event);
}
