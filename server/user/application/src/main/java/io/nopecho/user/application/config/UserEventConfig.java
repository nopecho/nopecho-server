package io.nopecho.user.application.config;

import io.nopecho.event.user.CreatedUserEvent;
import io.nopecho.user.application.handlers.event.TestEventHandler;
import io.nopecho.user.application.port.in.event.UserEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserEventConfig {

    private final TestEventHandler testEventHandler;

    @Bean
    public UserEventHandler userEventHandler() {
        UserEventHandler eventHandler = new UserEventHandler(
                testEventHandler
        );
        eventHandler.subscribe(CreatedUserEvent.class);

        return eventHandler;
    }
}
