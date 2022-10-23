package example.simple;

import eventloop.api.AbstractEventHandler;

public class SimpleEventHandler extends AbstractEventHandler<SimpleEvent> {
    @Override
    public void handle(SimpleEvent event) {
        System.out.println("SimpleEventHandler processed event with message: " + event.message());
    }
}
