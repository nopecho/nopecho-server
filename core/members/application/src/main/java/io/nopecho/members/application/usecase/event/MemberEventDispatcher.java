package io.nopecho.members.application.usecase.event;

import io.nopecho.event.DomainEvent;

public interface MemberEventDispatcher {

    void dispatch(DomainEvent event);
}
