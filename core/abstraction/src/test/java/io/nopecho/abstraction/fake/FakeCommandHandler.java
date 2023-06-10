package io.nopecho.abstraction.fake;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.command.CommandHandler;

public class FakeCommandHandler implements CommandHandler {

    public boolean isHandle = false;
    public Class<? extends Command> isSupportClass;

    public FakeCommandHandler(Class<? extends Command> isSupportClass) {
        this.isSupportClass = isSupportClass;
    }

    public static FakeCommandHandler isSupport(Command command) {
        return new FakeCommandHandler(command.getClass());
    }

    @Override
    public boolean canHandle(Command command) {
        return command.getClass().equals(FakeCommand.class);
    }

    @Override
    public void handle(Command command) {
        if (canHandle(command)) {
            this.isHandle = true;
        }
    }
}
