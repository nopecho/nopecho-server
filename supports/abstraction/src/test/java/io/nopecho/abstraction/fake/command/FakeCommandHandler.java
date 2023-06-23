package io.nopecho.abstraction.fake.command;

import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.event.EventPayload;

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
        return command.isType(FakeCommand.class);
    }

    @Override
    public EventPayload handle(Command command) {
        if (canHandle(command)) {
            this.isHandle = true;
            return null;
        }
        return null;
    }
}
