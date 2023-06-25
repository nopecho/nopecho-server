package io.nopecho.members.application.handlers.command;

import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.command.CompositeCommandHandler;
import io.nopecho.members.application.port.in.command.CommandHandleUseCase;

public class MemberCommandHandlers extends CompositeCommandHandler implements CommandHandleUseCase {

    public MemberCommandHandlers(CommandHandler<?, ?>... handlers) {
        super(handlers);
    }

    @Override
    public void validation(Command command) {
        command.selfValidation();
    }
}