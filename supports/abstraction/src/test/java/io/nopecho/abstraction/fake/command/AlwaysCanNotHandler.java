package io.nopecho.abstraction.fake.command;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.command.CommandHandler;
import io.nopecho.abstraction.event.EventPayload;

public class AlwaysCanNotHandler implements CommandHandler {

    @Override
    public boolean canHandle(Command command) {
        return false;
    }

    @Override
    public EventPayload handle(Command command) {
        return null;
    }
}
