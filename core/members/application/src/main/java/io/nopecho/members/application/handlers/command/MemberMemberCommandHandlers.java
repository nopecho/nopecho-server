package io.nopecho.members.application.handlers.command;

import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.command.CompositeCommandHandler;
import io.nopecho.members.application.port.in.command.MemberCommandUseCase;

public class MemberMemberCommandHandlers extends CompositeCommandHandler implements MemberCommandUseCase {

    public MemberMemberCommandHandlers(CommandHandler<?, ?>... handlers) {
        super(handlers);
    }

    @Override
    public void validation(Command command) {
        command.selfValidation();
    }
}