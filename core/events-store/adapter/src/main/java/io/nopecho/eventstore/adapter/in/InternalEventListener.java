package io.nopecho.eventstore.adapter.in;

import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventListener;
import io.nopecho.eventstore.application.port.in.StoreDomainEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InternalEventListener implements DomainEventListener {

    private final StoreDomainEventUseCase useCase;

    @Async
    @EventListener
    @Override
    public void receive(DomainEvent event) {
        useCase.store(event);
    }
}
