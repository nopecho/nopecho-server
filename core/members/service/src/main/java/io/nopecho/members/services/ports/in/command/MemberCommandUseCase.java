package io.nopecho.members.services.ports.in.command;

import io.nopecho.command.Command;
import io.nopecho.event.EventPayload;

public interface MemberCommandUseCase {

    EventPayload use(Command command);
}