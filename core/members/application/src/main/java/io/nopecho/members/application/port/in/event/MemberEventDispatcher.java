package io.nopecho.members.application.port.in.event;

import io.nopecho.event.DomainEvent;

public interface MemberEventDispatcher {

    void dispatch(DomainEvent event);
}
