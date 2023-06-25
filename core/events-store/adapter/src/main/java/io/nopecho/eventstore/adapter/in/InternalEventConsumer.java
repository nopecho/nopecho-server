package io.nopecho.eventstore.adapter.in;

import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventListener;
import io.nopecho.eventstore.application.port.in.StoreDomainEventUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InternalEventConsumer implements DomainEventListener {

    private final StoreDomainEventUseCase useCase;

    @Async
    @EventListener
    @Override
    public void receive(DomainEvent event) {
        useCase.store(event);
    }
}
