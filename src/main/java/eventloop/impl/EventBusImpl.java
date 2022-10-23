package eventloop.impl;

import eventloop.api.Event;
import eventloop.api.EventBus;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventBusImpl implements EventBus {
    private final BlockingQueue<Event> eventsQueue;


    public EventBusImpl() {
        eventsQueue = new LinkedBlockingQueue<>();
    }

    public EventBusImpl(int queueCapcity) {
         eventsQueue = new LinkedBlockingQueue<>(queueCapcity);
    }

    @Override
    public void push(Event event) {
        Objects.requireNonNull(event);
        eventsQueue.add(event);
    }

    @Override
    public Event take() {
        try {
            return eventsQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
