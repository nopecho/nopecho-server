package io.nopecho.user.application;

import io.nopecho.abstraction.event.AbstractEventListener;
import io.nopecho.abstraction.event.CompositeEventHandler;
import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.utils.Serializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class UserEventListener extends AbstractEventListener {

    public UserEventListener(CompositeEventHandler handler) {
        super(handler);
    }

    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void receive(DomainEvent event) {
        log.info("received event: {}", event.getType());
        tryHandle(event);
    }

    private void tryHandle(DomainEvent event) {
        try {
            super.handler.handle(event);
        } catch (Exception e) {
            log.error("[{}] failed to event handled. event: {}, message: {}",
                    this.getClass().getTypeName(), Serializer.serialize(event), e.getMessage());
        }
    }
}
