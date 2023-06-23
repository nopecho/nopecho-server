package io.nopecho.members.events;

import io.nopecho.event.EventPayload;
import lombok.Value;

@Value(staticConstructor = "of")
public class MemberSignupEvent implements EventPayload {
    String id;
}
