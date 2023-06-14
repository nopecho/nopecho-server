package io.nopecho.user.application.events;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.DomainEventHandler;
import io.nopecho.event.user.CreatedUserEvent;
import io.nopecho.user.application.port.in.command.UserCommandHandler;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatedUserEventHandler implements DomainEventHandler {

    private final UserCommandHandler commandHandler;

    @Override
    public boolean canHandle(DomainEvent domainEvent) {
        return domainEvent.isType(CreatedUserEvent.class);
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        log.info("handle created event: {}", Serializer.serialize(domainEvent));
    }
}