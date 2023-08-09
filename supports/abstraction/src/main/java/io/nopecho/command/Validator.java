package io.nopecho.command;

public interface Validator<C extends Command> {
    void preValidation(C command);
    void postValidation(C command);
}
