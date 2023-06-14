package io.nopecho.event.transaction.saga;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.VoidEvent;
import io.nopecho.abstraction.event.saga.EventTransaction;
import io.nopecho.event.user.CreatedUserEvent;
import io.nopecho.utils.Serializer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatedUserTransaction implements EventTransaction<VoidEvent, VoidEvent> {

    @Override
    public boolean isSupport(DomainEvent event) {
        return event.isType(CreatedUserEvent.class);
    }

    @Override
    public VoidEvent getCommitEvent(DomainEvent event) {
        CreatedUserEvent createdUserEvent = event.getPayload(CreatedUserEvent.class);
        log.info("commit event!!!! : {}", Serializer.serialize(createdUserEvent));
        return new VoidEvent();
    }

    @Override
    public VoidEvent getCompensationEvent(DomainEvent event) {
        CreatedUserEvent createdUserEvent = event.getPayload(CreatedUserEvent.class);
        log.info("compensation event!!!! : {}", Serializer.serialize(createdUserEvent));
        return new VoidEvent();
    }
}
