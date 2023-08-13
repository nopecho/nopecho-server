package io.nopecho.members.application.handlers.command.validators;

import io.nopecho.command.Validator;
import io.nopecho.members.application.ports.LoadMemberPort;
import io.nopecho.members.application.usecase.command.SignupCommand;
import io.nopecho.members.domain.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DuplicateEmailValidator implements Validator<SignupCommand> {

    private final LoadMemberPort loadMemberPort;

    @Override
    public void preValidation(SignupCommand command) {
        Email email = Email.of(command.getEmail());
        if (isDuplicateEmail(email)) {
            throw new IllegalArgumentException("is exist email. email: " + email.getValue());
        }
    }

    @Override
    public void postValidation(SignupCommand command) {
        // TBD
    }

    private boolean isDuplicateEmail(Email email) {
        return loadMemberPort.isExistEmail(email);
    }
}
