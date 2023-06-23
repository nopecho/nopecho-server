package io.nopecho.event.saga;

import io.nopecho.event.DomainEvent;

import java.util.Set;

public class OrchestratorContainer implements SagaOrchestrator {

    private final Set<SagaOrchestrator> orchestrators;

    public OrchestratorContainer(SagaOrchestrator... orchestrator) {
        this.orchestrators = Set.of(orchestrator);
    }

    @Override
    public boolean isSupport(DomainEvent event) {
        return this.orchestrators.stream()
                .anyMatch(o -> isSupport(event));
    }

    @Override
    public void orchestration(DomainEvent event) {
        SagaOrchestrator orchestrator = findOrchestrator(event);

        orchestrator.orchestration(event);
    }

    private SagaOrchestrator findOrchestrator(DomainEvent event) {
        return this.orchestrators.stream()
                .filter(o -> o.isSupport(event))
                .findFirst()
                .orElseThrow();
    }
}
