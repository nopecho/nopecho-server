package io.nopecho.event.adapter.persistence;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.event.EventStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringDataEventStore implements EventStore {

    private final DomainEventRepository repository;

    @Override
    public void store(DomainEvent event) {
        repository.save(createFrom(event));
    }

    private DomainEventEntity createFrom(DomainEvent event) {
        return DomainEventEntity.create(
                event.getId(),
                event.getType(),
                event.getPayload(),
                event.getOccurredAt()
        );
    }
}
