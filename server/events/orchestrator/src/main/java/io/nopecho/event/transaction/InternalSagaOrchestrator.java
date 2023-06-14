package io.nopecho.event.transaction;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.EventPublisher;
import io.nopecho.abstraction.event.saga.AbstractSagaOrchestrator;
import io.nopecho.abstraction.event.saga.EventTransactionManager;
import io.nopecho.event.EventStore;
import io.nopecho.event.transaction.annotaion.OrchestratorService;
import io.nopecho.utils.Serializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

@Slf4j
@OrchestratorService
public class InternalSagaOrchestrator extends AbstractSagaOrchestrator {

    private final EventStore eventStore;

    public InternalSagaOrchestrator(EventTransactionManager transactionManager, EventPublisher eventPublisher, EventStore eventStore) {
        super(transactionManager, eventPublisher);
        this.eventStore = eventStore;
    }

    @Async
    @Override
    public void onSuccess(DomainEvent event) {
        try {
            eventStore.store(event);
            DomainEvent commitEvent = transactionManager.commit(event);
            eventPublisher.publish(commitEvent);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed to event commit. event: {} :: message: {}", Serializer.serialize(event), e.getMessage());
        }
    }

    @Async
    @Override
    public void onFail(DomainEvent event) {
        try {
            eventStore.store(event);
            DomainEvent compensationEvent = transactionManager.rollback(event);
            eventPublisher.publish(compensationEvent);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed to event rollback. event: {} :: message: {}", Serializer.serialize(event), e.getMessage());
        }
    }
}