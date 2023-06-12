package io.nopecho.event.user;

import io.nopecho.abstraction.event.EventPayload;
import lombok.Value;

@Value(staticConstructor = "of")
public class CreatedUserEvent implements EventPayload {

    Long userId;
}
