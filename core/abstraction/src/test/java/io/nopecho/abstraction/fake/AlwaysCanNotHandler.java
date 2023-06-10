package io.nopecho.abstraction.fake;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.command.CommandHandler;

public class AlwaysCanNotHandler implements CommandHandler {

    @Override
    public boolean canHandle(Command command) {
        return false;
    }

    @Override
    public void handle(Command command) {
        //
    }
}
