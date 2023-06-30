package io.nopecho.members.ports.config;

import io.nopecho.members.ports.services.event.FooEventHandler;
import io.nopecho.members.ports.services.event.MemberMemberEventHandlers;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EventHandlerConfig {

    private final FooEventHandler fooEventHandler;

    @Bean
    public MemberMemberEventHandlers memberEventHandler() {
        return new MemberMemberEventHandlers(
                fooEventHandler
        );
    }
}
