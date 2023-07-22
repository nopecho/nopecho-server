package io.nopecho.members.services.handlers.command;

import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.command.CompositeCommandHandler;
import io.nopecho.event.EventPayload;
import io.nopecho.members.services.ports.in.command.MemberCommandUseCase;

public class MemberCommandHandlers extends CompositeCommandHandler implements MemberCommandUseCase {

    public MemberCommandHandlers(CommandHandler<?, ?>... handlers) {
        super(handlers);
    }

    @Override
    public EventPayload use(Command command) {
        return handle(command);
    }
}