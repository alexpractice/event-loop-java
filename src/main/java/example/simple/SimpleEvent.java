package example.simple;

import eventloop.api.Event;

public class SimpleEvent implements Event {
    private final String message;

    public SimpleEvent(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return "SimpleEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
