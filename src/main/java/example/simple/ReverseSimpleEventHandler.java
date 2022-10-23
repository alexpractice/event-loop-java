package example.simple;

import eventloop.api.AbstractEventHandler;

public class ReverseSimpleEventHandler extends AbstractEventHandler<SimpleEvent> {
    @Override
    public void handle(SimpleEvent event) {
        System.out.println("AnotherSimpleEventHandler has another logic: " + reverse(event.message()));
    }

    private String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
