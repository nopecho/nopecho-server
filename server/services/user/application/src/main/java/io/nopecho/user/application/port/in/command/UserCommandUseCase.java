package io.nopecho.user.application.port.in.command;

import io.nopecho.abstraction.command.Command;
import io.nopecho.abstraction.event.EventPayload;

public interface UserCommandUseCase {

    EventPayload handle(Command command);
}
