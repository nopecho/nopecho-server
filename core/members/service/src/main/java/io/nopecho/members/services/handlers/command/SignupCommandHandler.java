package io.nopecho.members.services.handlers.command;

import io.nopecho.aop.EventPublish;
import io.nopecho.command.Command;
import io.nopecho.command.CommandHandler;
import io.nopecho.members.domain.Email;
import io.nopecho.members.domain.Member;
import io.nopecho.members.domain.Name;
import io.nopecho.members.domain.PhoneNumber;
import io.nopecho.members.events.MemberSignupEvent;
import io.nopecho.members.services.handlers.command.validators.SignupValidators;
import io.nopecho.members.services.ports.in.command.SignupCommand;
import io.nopecho.members.services.ports.out.QueryMemberPort;
import io.nopecho.members.services.ports.out.SaveMemberPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SignupCommandHandler implements CommandHandler<SignupCommand, MemberSignupEvent> {

    private final SignupValidators validators;
    private final SaveMemberPort savePort;

    @Override
    public boolean canHandle(Command command) {
        return command.isType(SignupCommand.class);
    }

    @EventPublish(compensation = true, compensationType = MemberSignupEvent.class)
    @Transactional
    @Override
    public MemberSignupEvent handle(SignupCommand command) {
        validators.preValidation(command);

        Member member = Member.create(
                Name.of(command.getName()),
                Email.of(command.getEmail()),
                PhoneNumber.ofKorea("010")
        );

        Member saved = savePort.save(member);
        return MemberSignupEvent.from(saved);
    }
}