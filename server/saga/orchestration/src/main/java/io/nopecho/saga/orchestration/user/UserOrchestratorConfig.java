package io.nopecho.saga.orchestration.user;

import io.nopecho.abstraction.event.VoidEvent;
import io.nopecho.abstraction.event.saga.TransitionManager;
import io.nopecho.abstraction.event.saga.VoidTransition;
import io.nopecho.saga.orchestration.CommandGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UserOrchestratorConfig {

    private final CommandGateway gateway;

    @Bean
    public UserEventHandler userEventHandler() {
        return (UserEventHandler) TransitionManager.builder()
                .register(VoidTransition::new)
                .build();
    }

    @Bean
    public UserOrchestrator userOrchestrator(UserEventHandler handler) {
        UserOrchestrator orchestrator = new UserOrchestrator(gateway, handler);

        orchestrator.subscription(VoidEvent.class);
        return orchestrator;
    }
}
