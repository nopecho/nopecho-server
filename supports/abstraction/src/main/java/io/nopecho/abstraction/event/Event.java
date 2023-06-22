package io.nopecho.abstraction.event;

import java.time.LocalDateTime;

public interface Event {

    Long getId();

    LocalDateTime getOccurredAt();

    Object getPayload();

    String getType();

    <T extends EventPayload> T getPayload(Class<T> tClass);
}
