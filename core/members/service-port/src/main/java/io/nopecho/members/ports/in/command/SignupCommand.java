package io.nopecho.members.ports.in.command;

import io.nopecho.command.Command;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupCommand implements Command {

    private String name;
    private String email;
    private String loginToken;

    private SignupCommand(String name, String email, String loginToken) {
        this.name = name;
        this.email = email;
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
