package io.nopecho.user.application.config;

import io.nopecho.event.user.CreatedUserEvent;
import io.nopecho.user.application.events.CreatedUserEventHandler;
import io.nopecho.user.application.events.UserCompositeEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserEventConfig {

    private final CreatedUserEventHandler createdUserEventHandler;

    @Bean
    public UserCompositeEventHandler userEventHandler() {
        UserCompositeEventHandler compositeEventHandler = new UserCompositeEventHandler(
                createdUserEventHandler
        );
        compositeEventHandler.subscribe(CreatedUserEvent.class);

        return compositeEventHandler;
    }
}
