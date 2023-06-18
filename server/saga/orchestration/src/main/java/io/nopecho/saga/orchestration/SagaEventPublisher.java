package io.nopecho.saga.orchestration;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.EventPublisher;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SagaEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher publisher;

    @Async
    @Override
    public void publish(DomainEvent event) {
        publishOrThrow(event);
        log.info("published event: {}", Serializer.serialize(event));
    }

    private void publishOrThrow(DomainEvent event) {
        try {
            publisher.publishEvent(event);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("failed to event publish: event: %s : message %s", Serializer.serialize(event), e.getMessage())
            );
        }
    }
}