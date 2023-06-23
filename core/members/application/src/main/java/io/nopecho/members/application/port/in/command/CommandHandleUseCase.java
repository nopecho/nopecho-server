package io.nopecho.members.application.port.in.command;

import io.nopecho.command.Command;
import io.nopecho.event.EventPayload;

public interface CommandHandleUseCase {

    EventPayload handle(Command command);
}
