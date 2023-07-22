package io.nopecho.members.services.ports.in.event;

import io.nopecho.event.DomainEvent;

public interface MemberEventDispatcher {

    void dispatch(DomainEvent event);
}
