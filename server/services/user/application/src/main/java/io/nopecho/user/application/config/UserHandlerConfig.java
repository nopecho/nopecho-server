package io.nopecho.user.application.config;

import io.nopecho.user.application.handlers.command.TestCommandHandler;
import io.nopecho.user.application.handlers.query.TestQueryHandler;
import io.nopecho.user.application.port.in.command.UserCommandHandler;
import io.nopecho.user.application.port.in.query.UserQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserHandlerConfig {

    //command
    private final TestCommandHandler testCommandHandler;

    //query
    private final TestQueryHandler testQueryHandler;


    @Bean
    public UserCommandHandler userCompositeCommandHandler() {
        return new UserCommandHandler(
                testCommandHandler
        );
    }

    @Bean
    public UserQueryHandler userCompositeQueryHandler() {
        return new UserQueryHandler(
                testQueryHandler
        );
    }
}
