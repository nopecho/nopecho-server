package io.nopecho.members.ports.services.event;

import io.nopecho.event.DomainEventHandler;
import io.nopecho.event.EventPayload;
import io.nopecho.members.events.MemberSignupEvent;
import io.nopecho.members.ports.services.command.MemberCommandHandlers;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FooEventHandler implements DomainEventHandler<MemberSignupEvent> {

    private final MemberCommandHandlers commandHandler;

    @Override
    public boolean canHandle(EventPayload event) {
        return event.isType(MemberSignupEvent.class);
    }

    @Override
    public void handle(MemberSignupEvent event) {
        log.info(Serializer.serialize(event));
    }
}
