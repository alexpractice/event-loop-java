package example.chainofevents;

import eventloop.api.AbstractEventHandler;
import eventloop.api.EventPublisher;

public class IsOddNumberCheckingEventHandler extends AbstractEventHandler<IsOddNumberCheckingEvent> {

    private final EventPublisher publisher;

    public IsOddNumberCheckingEventHandler(EventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void handle(IsOddNumberCheckingEvent event) {
        System.out.println("we will is odd checking for: " + event.number());
        int number = event.number();
        boolean checkingResult = !(number % 2 == 0);
        publisher.publish(new IsOddNumberResultEvent(number, checkingResult));
    }
}
