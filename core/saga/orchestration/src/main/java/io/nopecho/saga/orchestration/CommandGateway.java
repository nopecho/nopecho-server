package io.nopecho.saga.orchestration;

import io.nopecho.abstraction.command.Command;

public interface CommandGateway {
    void send(Command command);
}
