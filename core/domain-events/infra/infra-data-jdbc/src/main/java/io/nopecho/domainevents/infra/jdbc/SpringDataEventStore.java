package io.nopecho.domainevents.infra.jdbc;

import io.nopecho.domainevents.application.ports.SaveDomainEventPort;
import io.nopecho.domainevents.infra.jdbc.entity.DomainEventEntity;
import io.nopecho.domainevents.infra.jdbc.repository.DomainEventRepository;
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
