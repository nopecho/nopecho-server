package io.nopecho.saga.members.event;

import io.nopecho.abstraction.event.EventPayload;
import lombok.Value;

@Value(staticConstructor = "of")
public class TestEvent implements EventPayload {

    Long id;
}
