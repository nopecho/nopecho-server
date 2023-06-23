package io.nopecho.members.application.handlers.command;

import io.nopecho.command.CommandHandler;
import io.nopecho.command.CompositeCommandHandler;
import io.nopecho.members.application.port.in.command.CommandHandleUseCase;

public class MemberCommandHandler extends CompositeCommandHandler implements CommandHandleUseCase {
    public MemberCommandHandler(CommandHandler<?, ?>... handlers) {
        super(handlers);
    }
}