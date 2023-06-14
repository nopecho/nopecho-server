package io.nopecho.user.application.events;

import io.nopecho.abstraction.event.AbstractEventListener;
import io.nopecho.abstraction.event.DomainEvent;
import io.nopecho.utils.Serializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserEventListener extends AbstractEventListener {

    public UserEventListener(UserCompositeEventHandler handler) {
        super(handler);
    }

    @Async
    @EventListener
    public void receive(DomainEvent event) {
        tryHandle(event);
    }

    private void tryHandle(DomainEvent event) {
        try {
            handler.handle(event);
        } catch (Exception e) {
            log.error("[{}] failed to event handled. event: {}, message: {}",
                    this.getClass().getTypeName(), Serializer.serialize(event), e.getMessage());
        }
    }
}
