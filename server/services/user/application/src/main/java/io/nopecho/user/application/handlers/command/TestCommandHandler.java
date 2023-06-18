package io.nopecho.user.application.handlers.command;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.command.CommandHandler;
import io.nopecho.abstraction.event.EventPublisher;
import io.nopecho.user.application.port.in.command.TestCommand;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TestCommandHandler implements CommandHandler {

    private final EventPublisher publisher;

    @Override
    public boolean canHandle(Command command) {
        return command.isType(TestCommand.class);
    }

    @Override
    public void handle(Command command) {
        TestCommand testCommand = tryCast(command, TestCommand.class);
        try {
            log.info("something logic command: {}", Serializer.serialize(testCommand));
            publisher.publish(null);
        } catch (Exception e) {
            log.error(e.getMessage());
            publisher.publish(null);
        }
    }
}