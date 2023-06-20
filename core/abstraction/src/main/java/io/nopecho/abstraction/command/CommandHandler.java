package io.nopecho.abstraction.command;

import io.nopecho.abstraction.event.EventPayload;

public interface CommandHandler {

    boolean canHandle(Command command);

    EventPayload handle(Command command);

    default <T extends Command> T tryCast(Command command, Class<T> classOfT) {
        if (canHandle(command)) {
            return classOfT.cast(command);
        }
        throw new RuntimeException(
                String.format("can not casting to command. because not handle this command: %s", command.getClass())
        );
    }
}

