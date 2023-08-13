package io.nopecho.members.application.config;

import io.nopecho.members.application.handlers.query.TestQueryHandler;
import io.nopecho.members.application.usecase.query.MemberQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberQueryHandlerConfig {

    private final TestQueryHandler testQueryHandler;

    @Bean
    public MemberQueryHandler memberQueryHandler() {
        return new MemberQueryHandler(
                testQueryHandler
        );
    }
}
