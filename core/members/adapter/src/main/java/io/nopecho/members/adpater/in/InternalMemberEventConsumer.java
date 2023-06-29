package io.nopecho.members.adpater.in;

import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventListener;
import io.nopecho.members.application.port.in.event.MemberEventDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InternalMemberEventConsumer implements DomainEventListener {

    private final MemberEventDispatcher useCase;

    @Async
    @EventListener
    public void receive(DomainEvent event) {
        useCase.dispatch(event);
    }
}
