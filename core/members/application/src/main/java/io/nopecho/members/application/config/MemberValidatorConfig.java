package io.nopecho.members.application.config;

import io.nopecho.members.application.handlers.command.validators.DuplicateEmailValidator;
import io.nopecho.members.application.handlers.command.validators.SignupValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberValidatorConfig {

    private final DuplicateEmailValidator duplicateEmailValidator;

    @Bean
    public SignupValidators signupValidators() {
        return new SignupValidators(
                duplicateEmailValidator
        );
    }
}
