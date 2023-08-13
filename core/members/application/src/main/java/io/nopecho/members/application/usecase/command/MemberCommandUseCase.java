package io.nopecho.members.application.usecase.command;

import io.nopecho.command.Command;
import io.nopecho.event.EventPayload;

public interface MemberCommandUseCase {

    EventPayload use(Command command);
}