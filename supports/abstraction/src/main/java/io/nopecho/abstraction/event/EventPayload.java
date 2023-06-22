package io.nopecho.abstraction.event;

public interface EventPayload {

    default boolean isType(Class<? extends EventPayload> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }

    default <T extends EventPayload> T tryCast(Class<T> clazz) {
        if (isType(clazz)) {
            return clazz.cast(this);
        }
        throw new ClassCastException(
                String.format("can not cast from: %s, to: %s", this.getClass().getTypeName(), clazz.getTypeName())
        );
    }
}
