package io.nopecho.event;

public final class CompensationEvent implements EventPayload {
    private final String type;
    private final Object fromCommand;

    private CompensationEvent(String type, Object command) {
        this.type = type;
        this.fromCommand = command;
    }

    public static CompensationEvent of(String type, Object command) {
        return new CompensationEvent(type, command);
    }

    public String getType() {
        return this.type;
    }

    public Object getFromCommand() {
        return this.fromCommand;
    }
}
