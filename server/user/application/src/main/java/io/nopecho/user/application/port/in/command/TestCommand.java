package io.nopecho.user.application.port.in.command;

import io.nopecho.abstraction.command.Command;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestCommand implements Command {

    private TestCommand() {
        this.selfValidation();
    }

    @Override
    public void selfValidation() {

    }
}
