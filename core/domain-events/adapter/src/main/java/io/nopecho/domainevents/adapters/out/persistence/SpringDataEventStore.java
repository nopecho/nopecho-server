package io.nopecho.domainevents.adapters.out.persistence;

import io.nopecho.domainevents.services.ports.out.SaveDomainEventPort;
import io.nopecho.event.DomainEvent;
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
        DomainEventEntity eventEntity = DomainEventEntity.of(event);
        repository.save(eventEntity);
    }
}
