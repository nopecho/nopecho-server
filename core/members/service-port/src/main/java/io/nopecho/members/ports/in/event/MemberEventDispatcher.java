package io.nopecho.members.ports.in.event;

import io.nopecho.event.DomainEvent;

public interface MemberEventDispatcher {

    void dispatch(DomainEvent event);
}
