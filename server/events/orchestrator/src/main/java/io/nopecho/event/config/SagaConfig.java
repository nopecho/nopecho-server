package io.nopecho.event.config;

import io.nopecho.abstraction.event.VoidEvent;
import io.nopecho.abstraction.event.saga.EventTransaction;
import io.nopecho.abstraction.event.saga.EventTransactionManager;
import io.nopecho.abstraction.event.saga.GeneralEventTransactionManager;
import io.nopecho.event.transaction.saga.CreatedUserTransaction;
import io.nopecho.event.transaction.saga.TestTransaction;
import io.nopecho.event.user.CreatedUserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;


@EnableAsync
@Configuration
@RequiredArgsConstructor
public class SagaConfig {

    @Bean
    public EventTransactionManager eventTransactionManager() {
        EventTransaction<CreatedUserEvent, CreatedUserEvent> test = new TestTransaction();
        EventTransaction<VoidEvent, VoidEvent> createdUser = new CreatedUserTransaction();

        return GeneralEventTransactionManager.builder()
                .register(createdUser)
                .register(test)
                .build();
    }
}