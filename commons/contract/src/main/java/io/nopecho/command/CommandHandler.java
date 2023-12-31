package io.nopecho.command;

import io.nopecho.event.EventPayload;

public interface CommandHandler<T extends Command, R extends EventPayload> {

    boolean canHandle(Command command);

    R handle(T command);

    default void validation(T command) {
        command.selfValidation();
    }
}