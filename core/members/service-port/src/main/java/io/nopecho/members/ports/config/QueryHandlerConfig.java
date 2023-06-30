package io.nopecho.members.ports.config;

import io.nopecho.members.ports.in.query.UserQueryHandler;
import io.nopecho.members.ports.services.query.TestQueryHandler;
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
