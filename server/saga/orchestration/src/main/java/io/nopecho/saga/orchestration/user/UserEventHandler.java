package io.nopecho.saga.orchestration.user;

import io.nopecho.abstraction.event.saga.EventTransition;
import io.nopecho.abstraction.event.saga.TransitionHandler;

import java.util.Set;

public class UserEventHandler extends TransitionHandler {

    public UserEventHandler(Set<EventTransition<?, ?>> transitions) {
        super(transitions);
    }
}
