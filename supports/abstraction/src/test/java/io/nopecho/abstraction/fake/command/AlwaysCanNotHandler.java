package io.nopecho.abstraction.fake.command;

import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.event.EventPayload;

public class AlwaysCanNotHandler implements CommandHandler {

    @Override
    public boolean canHandle(Command command) {
        return false;
    }

    @Override
    public EventPayload handle(Command command) {
        return null;
    }

    @Override
    public void validation(Command command) {

    }
}
