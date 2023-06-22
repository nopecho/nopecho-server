package io.nopecho.user.application.config;

import io.nopecho.user.application.handlers.command.TestCommandHandler;
import io.nopecho.user.application.handlers.command.UserCompositeCommandHandler;
import io.nopecho.user.application.handlers.query.TestQueryHandler;
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
    public UserCompositeCommandHandler userCompositeCommandHandler() {
        return new UserCompositeCommandHandler(
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
