package eventloop.impl;

import eventloop.api.Event;
import eventloop.api.EventBus;
import eventloop.api.EventPublisher;

import java.util.Objects;

public class EventPublisherImpl implements EventPublisher {
    private final EventBus eventBus;

    public EventPublisherImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void publish(Event event) {
        Objects.requireNonNull(event);
        eventBus.push(event);
    }
}
