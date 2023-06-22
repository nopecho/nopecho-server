package io.nopecho.abstraction.fake.command;

import io.nopecho.abstraction.command.Command;

public class FakeCommand implements Command {

    public boolean isValid;

    public FakeCommand(boolean isValid) {
        this.isValid = isValid;
    }

    public FakeCommand() {

    }

    public static FakeCommand isValid(boolean bool) {
        return new FakeCommand(bool);
    }

    public static FakeCommand of() {
        return new FakeCommand(true);
    }

    @Override
    public void selfValidation() {
        if (!isValid) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean isType(Class<? extends Command> clazz) {
        return this.getClass().equals(clazz);
    }
}
