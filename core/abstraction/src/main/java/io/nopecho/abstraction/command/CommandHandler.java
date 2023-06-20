package io.nopecho.abstraction.command;

import io.nopecho.abstraction.event.EventPayload;

public interface CommandHandler<T extends Command, R extends EventPayload> {

    boolean canHandle(Command command);

    R handle(T command);
}