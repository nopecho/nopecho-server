package io.nopecho.springevents.adapters.out.persistence;

import io.nopecho.event.DomainEvent;
import io.nopecho.springevents.ports.out.SaveDomainEventPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringDataEventStore implements SaveDomainEventPort {

    private final DomainEventRepository repository;

    @Override
    public void save(DomainEvent event) {
        repository.save(createFrom(event));
    }

    private DomainEventEntity createFrom(DomainEvent event) {
        return DomainEventEntity.create(
                event.getId(),
                event.getType(),
                event.getPayloadObject(),
                event.getOccurredAt()
        );
    }
}