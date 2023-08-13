package io.nopecho.command;

import io.nopecho.utils.SelfValidator;

public interface Command extends SelfValidator {

    boolean isType(Class<? extends Command> clazz);
}
