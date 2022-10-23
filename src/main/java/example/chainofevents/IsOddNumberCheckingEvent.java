package example.chainofevents;

import eventloop.api.Event;

public class IsOddNumberCheckingEvent implements Event {
    private final int number;

    public IsOddNumberCheckingEvent(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }

    @Override
    public String toString() {
        return "IsOddNumberCheckingEvent{" +
                "number=" + number +
                '}';
    }
}
