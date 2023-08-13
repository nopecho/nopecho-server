package io.nopecho.domainevents.interfaces.internal;

import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventPublisher;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringDomainEventPublisher implements DomainEventPublisher {

    private final ApplicationEventPublisher publisher;

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void publish(DomainEvent event) {
        tryPublish(event);
    }

    private void tryPublish(DomainEvent event) {
        try {
            publisher.publishEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed to event publish: event: {}, message: {}",
                    Serializer.serialize(event),
                    e.getMessage());
        }
    }
}