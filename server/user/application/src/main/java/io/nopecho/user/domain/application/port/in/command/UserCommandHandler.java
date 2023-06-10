package io.nopecho.user.domain.application.port.in.command;

import io.nopecho.abstraction.command.CommandHandler;
import io.nopecho.abstraction.command.CompositeCommandHandler;

public class UserCommandHandler extends CompositeCommandHandler {

    public UserCommandHandler(CommandHandler... handlers) {
        super(handlers);
    }
}
