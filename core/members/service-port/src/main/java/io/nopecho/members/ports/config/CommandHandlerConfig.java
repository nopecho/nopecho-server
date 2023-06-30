package io.nopecho.members.ports.config;

import io.nopecho.members.ports.services.command.MemberCommandHandlers;
import io.nopecho.members.ports.services.command.SignupCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandHandlerConfig {
    private final SignupCommandHandler signupCommandHandler;

    @Bean
    public MemberCommandHandlers memberCommandHandler() {
        return new MemberCommandHandlers(
                signupCommandHandler
        );
    }
}
