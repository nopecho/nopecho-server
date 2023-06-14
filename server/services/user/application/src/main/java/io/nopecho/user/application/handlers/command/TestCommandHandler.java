package io.nopecho.user.application.handlers.command;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.command.CommandHandler;
import io.nopecho.user.application.port.in.command.TestCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestCommandHandler implements CommandHandler {

    @Override
    public boolean canHandle(Command command) {
        return command.isType(TestCommand.class);
    }

    @Override
    public void handle(Command command) {

    }
}
