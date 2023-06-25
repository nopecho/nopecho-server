package io.nopecho.command;

import io.nopecho.event.EventPayload;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class CompositeCommandHandler implements CommandHandler<Command, EventPayload> {

    private final List<CommandHandler<?, ?>> handlers;

    protected CompositeCommandHandler(CommandHandler<?, ?>... handlers) {
        this.handlers = Collections.unmodifiableList(Arrays.asList(handlers));
    }

    @Override
    public boolean canHandle(Command command) {
        return this.handlers.stream()
                .anyMatch(h -> h.canHandle(command));
    }

    @Override
    public EventPayload handle(Command command) {
        if (canHandle(command)) {
            return handleOrThrow(command);
        }
        throw new RuntimeException(String.format("not found command handler to command: %s", getCommandName(command)));
    }

    private EventPayload handleOrThrow(Command command) {
        CommandHandler handler = findHandlerOrThrow(command);
        return handler.handle(command);
    }

    private CommandHandler findHandlerOrThrow(Command command) {
        return this.handlers.stream()
                .filter(h -> h.canHandle(command))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("not found supported handlers to command: %s", getCommandName(command))));
    }

    private String getCommandName(Command command) {
        return command.getClass().getName();
    }
}
