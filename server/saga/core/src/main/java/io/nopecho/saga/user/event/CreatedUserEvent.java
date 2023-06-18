package io.nopecho.saga.user.event;

import io.nopecho.abstraction.event.EventPayload;
import lombok.Value;

@Value(staticConstructor = "of")
public class CreatedUserEvent implements EventPayload {

    Long userId;
}
