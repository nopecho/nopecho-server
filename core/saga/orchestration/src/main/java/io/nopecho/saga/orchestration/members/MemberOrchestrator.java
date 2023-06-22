package io.nopecho.saga.orchestration.members;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.saga.AbstractSagaOrchestrator;
import io.nopecho.saga.orchestration.CommandGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MemberOrchestrator extends AbstractSagaOrchestrator {

    private final CommandGateway commandGateway;
    private final MemberEventHandler eventHandler;

    @Override
    public boolean isSupport(DomainEvent event) {
        return this.supportedEvents.stream()
                .anyMatch(event::isType);
    }

    @Override
    public void orchestration(DomainEvent event) {
        Command command = eventHandler.nextTransition(event);

        commandGateway.send(command);
    }
}