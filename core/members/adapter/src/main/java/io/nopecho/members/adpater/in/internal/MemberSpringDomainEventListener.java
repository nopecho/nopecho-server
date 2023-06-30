package io.nopecho.members.adpater.in.internal;

import io.nopecho.event.DomainEvent;
import io.nopecho.event.DomainEventListener;
import io.nopecho.members.ports.in.event.MemberEventDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberSpringDomainEventListener implements DomainEventListener {

    private final MemberEventDispatcher memberEventDispatcher;

    @Async
    @EventListener
    public void receive(DomainEvent event) {
        memberEventDispatcher.dispatch(event);
    }
}
