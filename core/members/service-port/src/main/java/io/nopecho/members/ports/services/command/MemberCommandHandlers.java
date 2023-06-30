package io.nopecho.members.ports.services.command;

import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.command.CompositeCommandHandler;
import io.nopecho.event.EventPayload;
import io.nopecho.members.ports.in.command.MemberCommandUseCase;

public class MemberCommandHandlers extends CompositeCommandHandler implements MemberCommandUseCase {

    public MemberCommandHandlers(CommandHandler<?, ?>... handlers) {
        super(handlers);
    }

    @Override
    public EventPayload doHandle(Command command) {
        return handle(command);
    }
}