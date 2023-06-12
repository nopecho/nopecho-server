package io.nopecho.event;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.DomainEventPublisher;
import io.nopecho.event.core.EventStore;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveAndEventPublisher implements DomainEventPublisher {

    private final EventStore eventStore;
    private final ApplicationEventPublisher publisher;

    @Async
    @Override
    public void publish(DomainEvent event) {
        tryStore(event);
        log.info("publish event: {}", Serializer.serialize(event));
        publisher.publishEvent(event);
    }

    private void tryStore(DomainEvent event) {
        try {
            this.eventStore.store(event);
        } catch (Exception e) {
            log.error("event persist is failed. massage: {}", e.getMessage());
        }
    }
}