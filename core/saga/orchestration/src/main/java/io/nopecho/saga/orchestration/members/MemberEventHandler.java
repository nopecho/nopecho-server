package io.nopecho.saga.orchestration.members;

import io.nopecho.abstraction.event.saga.EventTransition;
import io.nopecho.abstraction.event.saga.TransitionHandler;

import java.util.Set;

public class MemberEventHandler extends TransitionHandler {

    public MemberEventHandler(Set<EventTransition<?, ?>> transitions) {
        super(transitions);
    }
}
