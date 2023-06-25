package io.nopecho.members.application.port.in.command;

import io.nopecho.command.Command;
import io.nopecho.members.domain.OauthMethod;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupCommand implements Command {

    private String name;
    private String email;
    private OauthMethod loginMethod;
    private String loginToken;

    private SignupCommand(String name, String email, OauthMethod loginMethod, String loginToken) {
        this.name = name;
        this.email = email;
        this.loginMethod = loginMethod;
        this.loginToken = loginToken;

        selfValidation();
    }

    @Override
    public void selfValidation() {
    }

    @Override
    public boolean isType(Class<? extends Command> clazz) {
        return this.getClass().equals(clazz);
    }
}
