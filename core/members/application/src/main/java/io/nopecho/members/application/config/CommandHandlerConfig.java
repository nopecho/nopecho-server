package io.nopecho.members.application.config;

import io.nopecho.members.application.handlers.command.MemberMemberCommandHandlers;
import io.nopecho.members.application.handlers.command.SignupCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CommandHandlerConfig {
    private final SignupCommandHandler signupCommandHandler;

    @Bean
    public MemberMemberCommandHandlers memberCommandHandler() {
        return new MemberMemberCommandHandlers(
                signupCommandHandler
        );
    }
}
