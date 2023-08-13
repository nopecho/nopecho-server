package io.nopecho.abstraction.fake.command;

import io.nopecho.command.Command;

public class FakeCommand2 implements Command {
    @Override
    public void selfValidation() {

    }

    @Override
    public boolean isType(Class<? extends Command> clazz) {
        return this.getClass().equals(clazz);
    }
}
