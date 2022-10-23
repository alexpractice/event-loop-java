package example.chainofevents;

import eventloop.api.AbstractEventHandler;

public class IsOddNumberResultEventHandler extends AbstractEventHandler<IsOddNumberResultEvent> {

    @Override
    public void handle(IsOddNumberResultEvent event) {
        System.out.println("is " + event.number() + " odd number? that's " + event.isOdd());
    }
}
