package io.nopecho.members.services.config;

import io.nopecho.members.services.handlers.event.FooEventHandler;
import io.nopecho.members.services.handlers.event.MemberEventHandlers;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberEventHandlerConfig {

    private final FooEventHandler fooEventHandler;

    @Bean
    public MemberEventHandlers memberEventHandlers() {
        return new MemberEventHandlers(
                fooEventHandler
        );
    }
}
