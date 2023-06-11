package io.nopecho.abstraction.event;

import io.nopecho.utils.LongIdGenerator;
import io.nopecho.utils.Serializer;
import io.nopecho.utils.Throws;

import java.time.LocalDateTime;

public final class DomainEvent implements Event {

    private Long id;
    private Object payload;
    private String type;
    private LocalDateTime occurredAt;

    public DomainEvent() {
    }

    public DomainEvent(Long id, LocalDateTime occurredAt, String type, Object payload) {
        this.id = id;
        this.payload = payload;
        this.type = type;
        this.occurredAt = occurredAt;
    }

    private DomainEvent(Object payload) {
        Throws.ifNull(payload, "payload must be not null!");
        this.id = LongIdGenerator.gen();
        this.payload = payload;
        this.type = payload.getClass().getTypeName();
        this.occurredAt = LocalDateTime.now();
    }

    public static DomainEvent of(Object payload) {
        return new DomainEvent(payload);
    }

    public static DomainEvent deserialize(String serialized) {
        return Serializer.deserialize(serialized, DomainEvent.class);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public LocalDateTime getOccurredAt() {
        return this.occurredAt;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Object getPayload() {
        return this.payload;
    }

    @Override
    public <T extends EventPayload> T getPayload(Class<T> tClass) {
        return getEventPayload().tryCast(tClass);
    }

    public boolean isType(Class<? extends EventPayload> clazz) {
        return getEventPayload().isType(clazz);
    }

    public String serialize() {
        return Serializer.serialize(this);
    }

    private EventPayload getEventPayload() {
        try {
            return (EventPayload) this.payload;
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("this event payload is can not down casting. this event payload type is %s", this.payload.getClass().getTypeName()));
        }
    }
}
