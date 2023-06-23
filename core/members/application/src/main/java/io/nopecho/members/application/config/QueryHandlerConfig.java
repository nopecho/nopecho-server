package io.nopecho.members.application.config;

import io.nopecho.members.application.handlers.query.TestQueryHandler;
import io.nopecho.members.application.port.in.query.UserQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QueryHandlerConfig {
    private final TestQueryHandler testQueryHandler;

    @Bean
    public UserQueryHandler userCompositeQueryHandler() {
        return new UserQueryHandler(
                testQueryHandler
        );
    }
}
