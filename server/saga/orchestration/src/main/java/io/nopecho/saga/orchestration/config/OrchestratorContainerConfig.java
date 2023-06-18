package io.nopecho.saga.orchestration.config;

import io.nopecho.abstraction.event.saga.OrchestrationContainer;
import io.nopecho.saga.orchestration.user.UserOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@Configuration
@RequiredArgsConstructor
public class OrchestratorContainerConfig {

    private final UserOrchestrator userOrchestrator;

    @Bean
    public OrchestrationContainer container() {
        return new OrchestrationContainer(
                userOrchestrator
        );
    }
}