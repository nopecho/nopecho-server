package io.nopecho.saga.orchestration.config;

import io.nopecho.abstraction.event.saga.OrchestratorContainer;
import io.nopecho.saga.orchestration.members.MemberOrchestrator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@Configuration
@RequiredArgsConstructor
public class OrchestratorContainerConfig {

    private final MemberOrchestrator memberOrchestrator;

    @Bean
    public OrchestratorContainer container() {
        return new OrchestratorContainer(
                memberOrchestrator
        );
    }
}