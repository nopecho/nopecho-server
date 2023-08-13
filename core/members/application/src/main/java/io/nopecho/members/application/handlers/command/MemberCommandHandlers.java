package io.nopecho.members.application.handlers.command;

import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.command.CompositeCommandHandler;
import io.nopecho.event.EventPayload;
import io.nopecho.members.application.usecase.command.MemberCommandUseCase;

public class MemberCommandHandlers extends CompositeCommandHandler implements MemberCommandUseCase {

    public MemberCommandHandlers(CommandHandler<?, ?>... handlers) {
        super(handlers);
    }

    @Override
    public EventPayload use(Command command) {
        return handle(command);
    }
}