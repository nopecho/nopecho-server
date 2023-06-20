package io.nopecho.user.application.handlers.command;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.command.CommandHandler;
import io.nopecho.abstraction.event.EventPayload;
import io.nopecho.user.application.port.in.command.TestCommand;
import io.nopecho.utils.Serializer;
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
    public EventPayload handle(Command command) {
        TestCommand testCommand = tryCast(command, TestCommand.class);
        log.info("something logic command: {}", Serializer.serialize(testCommand));
        return null;
    }
}