package io.nopecho.members.application.config;

import io.nopecho.members.application.handlers.command.MemberCommandHandlers;
import io.nopecho.members.application.handlers.command.TestCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandHandlerConfig {
    private final TestCommandHandler testCommandHandler;

    @Bean
    public MemberCommandHandlers memberCommandHandler() {
        return new MemberCommandHandlers(
                testCommandHandler
        );
    }
}
