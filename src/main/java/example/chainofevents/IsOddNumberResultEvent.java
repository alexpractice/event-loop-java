package example.chainofevents;

import eventloop.api.Event;

public class IsOddNumberResultEvent implements Event {
    private final int number;
    private final boolean result;

    public IsOddNumberResultEvent(int number, boolean result) {
        this.number = number;
        this.result = result;
    }

    public int number() {
        return number;
    }

    public boolean isOdd() {
        return result;
    }

    @Override
    public String toString() {
        return "IsOddNumberResultEvent{" +
                "number=" + number +
                ", result=" + result +
                '}';
    }
}
