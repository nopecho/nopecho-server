package io.nopecho.members.application.handlers.command;

import io.nopecho.aop.EventPublish;
import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.members.application.port.in.command.SignupCommand;
import io.nopecho.members.application.port.out.QueryMemberPort;
import io.nopecho.members.application.port.out.SaveMemberPort;
import io.nopecho.members.domain.*;
import io.nopecho.members.events.MemberSignupEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupCommandHandler implements CommandHandler<SignupCommand, MemberSignupEvent> {

    private final SaveMemberPort savePort;
    private final QueryMemberPort queryPort;

    @Override
    public boolean canHandle(Command command) {
        return command.isType(SignupCommand.class);
    }

    @Transactional
    @EventPublish
    @Override
    public MemberSignupEvent handle(SignupCommand command) {
        validation(command);

        Member member = Member.createFrom(
                Name.of(command.getName()),
                Email.of(command.getEmail()),
                LoginMethod.from(command.getLoginMethod(), LoginToken.of(command.getLoginToken())));

        Member saved = savePort.save(member);

        return MemberSignupEvent.of(saved);
    }

    @Override
    public void validation(SignupCommand command) {
        Email email = Email.of(command.getEmail());
        if (isDuplicateEmail(email)) {
            throw new IllegalArgumentException("is exist email. email: " + email.get());
        }
    }

    private boolean isDuplicateEmail(Email email) {
        try {
            queryPort.findByEmail(email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}