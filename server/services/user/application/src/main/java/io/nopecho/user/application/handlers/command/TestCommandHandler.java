package io.nopecho.user.application.handlers.command;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.command.CommandHandler;
import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.saga.SagaOrchestrator;
import io.nopecho.event.transaction.annotaion.CommandHandlerService;
import io.nopecho.event.user.TestEvent;
import io.nopecho.user.application.port.in.command.TestCommand;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CommandHandlerService
@RequiredArgsConstructor
public class TestCommandHandler implements CommandHandler {

    private final SagaOrchestrator orchestrator;

    @Override
    public boolean canHandle(Command command) {
        return command.isType(TestCommand.class);
    }

    @Override
    public void handle(Command command) {
        TestCommand testCommand = tryCast(command, TestCommand.class);
        try {
            log.info("something logic command: {}", Serializer.serialize(testCommand));
            orchestrator.onSuccess(DomainEvent.of(TestEvent.of(testCommand.getId())));
        } catch (Exception e) {
            orchestrator.onFail(DomainEvent.of(TestEvent.of(testCommand.getId())));
            throw new RuntimeException(e.getMessage());
        }
    }
}