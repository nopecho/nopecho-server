package io.nopecho.members.services.config;

import io.nopecho.members.services.handlers.command.MemberCommandHandlers;
import io.nopecho.members.services.handlers.command.SignupCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberCommandHandlerConfig {

    private final SignupCommandHandler signupCommandHandler;

    @Bean
    public MemberCommandHandlers memberCommandHandlers() {
        return new MemberCommandHandlers(
                signupCommandHandler
        );
    }
}
