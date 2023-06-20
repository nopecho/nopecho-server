package io.nopecho.abstraction.command;

import io.nopecho.abstraction.event.EventPayload;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class CompositeCommandHandler implements CommandHandler {

    private final List<CommandHandler> handlers;

    protected CompositeCommandHandler(CommandHandler... handlers) {
        this.handlers = Collections.unmodifiableList(Arrays.asList(handlers));
    }

    @Override
    public boolean canHandle(Command command) {
        return this.handlers.stream()
                .anyMatch(h -> h.canHandle(command));
    }

    @Override
    public EventPayload handle(Command command) {
        return handleOrThrow(command);
    }

    private EventPayload handleOrThrow(Command command) {
        CommandHandler handler = findHandlerOrThrow(command);
        try {
            return handler.handle(command);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("error from [%s]. message: %s", getCommandName(command), e.getMessage())
            );
        }
    }

    private CommandHandler findHandlerOrThrow(Command command) {
        return this.handlers.stream()
                .filter(h -> h.canHandle(command))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("not found supported handlers to command: %s", getCommandName(command)))
                );
    }

    private String getCommandName(Command command) {
        return command.getClass().getName();
    }
}
