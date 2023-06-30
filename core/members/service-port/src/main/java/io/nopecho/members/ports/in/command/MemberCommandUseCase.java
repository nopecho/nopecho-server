package io.nopecho.members.ports.in.command;

import io.nopecho.command.Command;
import io.nopecho.event.EventPayload;

public interface MemberCommandUseCase {

    EventPayload doHandle(Command command);
}