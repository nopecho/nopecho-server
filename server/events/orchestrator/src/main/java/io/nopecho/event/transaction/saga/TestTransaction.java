package io.nopecho.event.transaction.saga;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.saga.EventTransaction;
import io.nopecho.event.user.CreatedUserEvent;
import io.nopecho.event.user.TestEvent;
import io.nopecho.utils.Serializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestTransaction implements EventTransaction<CreatedUserEvent, CreatedUserEvent> {

    @Override
    public boolean isSupport(DomainEvent event) {
        return event.isType(TestEvent.class);
    }

    @Override
    public CreatedUserEvent getCommitEvent(DomainEvent event) {
        TestEvent payload = event.getPayload(TestEvent.class);
        log.info(Serializer.serialize(payload));
        return CreatedUserEvent.of(payload.getId());
    }

    @Override
    public CreatedUserEvent getCompensationEvent(DomainEvent event) {
        TestEvent payload = event.getPayload(TestEvent.class);
        log.info(Serializer.serialize(payload));
        return CreatedUserEvent.of(payload.getId());
    }
}
