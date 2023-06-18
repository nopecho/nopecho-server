package io.nopecho.abstraction.command;

public final class VoidCommand implements Command {

    @Override
    public boolean isType(Class<? extends Command> clazz) {
        return clazz.getTypeName().equals(this.getClass().getTypeName());
    }

    @Override
    public void selfValidation() {
    }
}
