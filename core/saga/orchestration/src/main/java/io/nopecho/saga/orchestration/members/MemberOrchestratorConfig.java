package io.nopecho.saga.orchestration.members;

import io.nopecho.abstraction.event.VoidEvent;
import io.nopecho.abstraction.event.saga.TransitionHandler;
import io.nopecho.abstraction.event.saga.VoidTransition;
import io.nopecho.saga.orchestration.CommandGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MemberOrchestratorConfig {

    private final CommandGateway gateway;

    @Bean
    public MemberEventHandler userEventHandler() {
        return (MemberEventHandler) TransitionHandler.builder()
                .register(VoidTransition::new)
                .build();
    }

    @Bean
    public MemberOrchestrator userOrchestrator(MemberEventHandler handler) {
        MemberOrchestrator orchestrator = new MemberOrchestrator(gateway, handler);

        orchestrator.subscription(VoidEvent.class);
        return orchestrator;
    }
}
