package io.nopecho.abstraction.fake.command;

import io.nopecho.abstraction.command.Command;

public class NotSupportCommand implements Command {

    @Override
    public void selfValidation() {

    }

    @Override
    public boolean isType(Class<? extends Command> clazz) {
        return false;
    }
}
