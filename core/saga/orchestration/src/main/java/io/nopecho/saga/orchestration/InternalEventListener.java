package io.nopecho.saga.orchestration;

import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.abstraction.event.DomainEventListener;
import io.nopecho.abstraction.event.saga.OrchestratorContainer;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class InternalEventListener implements DomainEventListener {

    private final EventStore eventStore;
    private final OrchestratorContainer container;

    /**
     * 이벤트 브로커(e.g. kafka, aws kinesis)를 이용하는 분산 환경이라면 각 토픽별로 listen?
     *
     * @param event : 각 도메인에서 발생한 이벤트
     */
    @Async
    @EventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void receive(DomainEvent event) {
        eventStore.store(event);
        tryOrchestration(event);
    }

    private void tryOrchestration(DomainEvent event) {
        try {
            container.orchestration(event);
        } catch (Exception e) {
            log.error("[{}] failed to event orchestration. event: {}, message: {}",
                    this.getClass().getTypeName(), Serializer.serialize(event), e.getMessage());
        }
    }
}
