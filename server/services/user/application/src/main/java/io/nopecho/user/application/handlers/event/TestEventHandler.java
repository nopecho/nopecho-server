package io.nopecho.user.application.handlers.event;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.DomainEventHandler;
import io.nopecho.event.user.CreatedUserEvent;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestEventHandler implements DomainEventHandler {

    @Override
    public boolean canHandle(DomainEvent domainEvent) {
        return domainEvent.isType(CreatedUserEvent.class);
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        log.info("handled event! {}", Serializer.serialize(domainEvent));
    }
}
