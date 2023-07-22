package io.nopecho.domainevents.adapters.in;

import io.nopecho.domainevents.services.ports.in.StoreDomainEventUseCase;
import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringDomainEventListener implements DomainEventListener {

    private final StoreDomainEventUseCase storeUseCase;

    @Async
    @EventListener
    @Override
    public void receive(DomainEvent event) {
        storeUseCase.store(event);
    }
}
