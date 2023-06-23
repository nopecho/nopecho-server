package io.nopecho.members.application.handlers.command;

import io.nopecho.aop.EventPublish;
import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.members.application.port.in.command.TestCommand;
import io.nopecho.members.events.MemberSignupEvent;
import io.nopecho.utils.Serializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestCommandHandler implements CommandHandler<TestCommand, MemberSignupEvent> {

    @Override
    public boolean canHandle(Command command) {
        return command.isType(TestCommand.class);
    }

    @Transactional
    @EventPublish
    @Override
    public MemberSignupEvent handle(TestCommand command) {
        log.info("something logic command: {}", Serializer.serialize(command));
        return MemberSignupEvent.of(command.getId().toString());
    }
}