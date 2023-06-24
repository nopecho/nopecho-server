package io.nopecho.members.application.config;

import io.nopecho.members.application.handlers.event.FooEventHandler;
import io.nopecho.members.application.handlers.event.MemberEventHandlers;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EventHandlerConfig {

    private final FooEventHandler fooEventHandler;

    @Bean
    public MemberEventHandlers memberEventHandler() {
        return new MemberEventHandlers(
                fooEventHandler
        );
    }
}
