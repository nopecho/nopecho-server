package io.nopecho.user.application.handlers.command;

import io.nopecho.abstraction.command.CommandHandler;
import io.nopecho.abstraction.command.CompositeCommandHandler;
import io.nopecho.user.application.port.in.command.UserCommandUseCase;

public class UserCompositeCommandHandler extends CompositeCommandHandler
        implements UserCommandUseCase {

    public UserCompositeCommandHandler(CommandHandler<?, ?>... handlers) {
        super(handlers);
    }
}