package io.nopecho.saga.orchestration.user;

import io.nopecho.abstraction.event.saga.EventTransition;
import io.nopecho.abstraction.event.saga.TransitionManager;

import java.util.Set;

public class UserEventHandler extends TransitionManager {

    public UserEventHandler(Set<EventTransition<?, ?>> transitions) {
        super(transitions);
    }
}
