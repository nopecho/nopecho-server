package io.nopecho.domainevents.ports.services;

import io.nopecho.domainevents.ports.in.StoreDomainEventUseCase;
import io.nopecho.domainevents.ports.out.SaveDomainEventPort;
import io.nopecho.event.DomainEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventStoreService implements StoreDomainEventUseCase {

    private final SaveDomainEventPort savePort;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void store(DomainEvent event) {
        savePort.save(event);
    }
}
