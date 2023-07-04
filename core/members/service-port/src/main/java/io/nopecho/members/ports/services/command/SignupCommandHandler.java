package io.nopecho.members.ports.services.command;

import io.nopecho.aop.EventPublish;
import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.members.events.MemberSignupEvent;
import io.nopecho.members.models.Email;
import io.nopecho.members.models.Member;
import io.nopecho.members.models.Name;
import io.nopecho.members.models.PhoneNumber;
import io.nopecho.members.ports.in.command.SignupCommand;
import io.nopecho.members.ports.out.QueryMemberPort;
import io.nopecho.members.ports.out.SaveMemberPort;
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

    @EventPublish
    @Transactional
    @Override
    public MemberSignupEvent handle(SignupCommand command) {
        validation(command);

        Member member = Member.create(
                Name.of(command.getName()),
                Email.of(command.getEmail()),
                PhoneNumber.ofKorea("010")
        );

        Member saved = savePort.save(member);

        return MemberSignupEvent.from(saved);
    }

    @Override
    public void validation(SignupCommand command) {
        Email email = Email.of(command.getEmail());
        if (isDuplicateEmail(email)) {
            throw new IllegalArgumentException("is exist email. email: " + email.getValue());
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