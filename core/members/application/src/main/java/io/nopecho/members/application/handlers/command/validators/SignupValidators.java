package io.nopecho.members.application.handlers.command.validators;

import io.nopecho.command.Validator;
import io.nopecho.members.application.usecase.command.SignupCommand;

import java.util.List;

public class SignupValidators implements Validator<SignupCommand> {

    private final List<Validator<SignupCommand>> validators;

    @SafeVarargs
    public SignupValidators(Validator<SignupCommand>... validators) {
        this.validators = List.of(validators);
    }

    @Override
    public void preValidation(SignupCommand command) {
        this.validators.forEach(v -> v.preValidation(command));
    }

    @Override
    public void postValidation(SignupCommand command) {
        this.validators.forEach(v -> v.postValidation(command));
    }
}
