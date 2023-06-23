package io.nopecho.event;

import java.time.LocalDateTime;

public interface Event {

    Long getId();

    LocalDateTime getOccurredAt();

    Object getPayloadObject();

    String getType();

    <T extends EventPayload> T getPayload(Class<T> tClass);

    EventPayload getPayload();
}
