package io.nopecho.members.services.ports.in.command;

import io.nopecho.command.Command;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupCommand implements Command {

    private final String name;
    private final String email;
    private final String loginToken;

    @Override
    public void selfValidation() {
    }

    @Override
    public boolean isType(Class<? extends Command> clazz) {
        return this.getClass().equals(clazz);
    }
}
