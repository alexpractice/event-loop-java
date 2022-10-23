package eventloop.impl;

import eventloop.api.AbstractEventHandler;
import eventloop.api.Event;
import eventloop.api.EventBus;
import eventloop.api.EventLoop;

import java.util.*;

public class EventLoopImpl implements EventLoop {
    private final Map<Class<Event>, List<AbstractEventHandler<Event>>> handlersMap = new HashMap<>();

    private final EventBus eventBus;

    public EventLoopImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void addEventHandler(AbstractEventHandler<Event> eventHandler) {
        Class key = eventHandler.getProcessingEventClass();
        handlersMap.computeIfAbsent(key, k -> new LinkedList<>()).add(eventHandler);
    }

    @Override
    public void start() {
        Thread workingThread = new Thread(this::working);
        workingThread.setName("Event-loop-thread");
        workingThread.start();
    }

    private void working() {
        while (true) {
            Event event = eventBus.take();
            Class eventClass = event.getClass();
            List<AbstractEventHandler<Event>> handlersList = handlersMap.get(eventClass);
            if (Objects.isNull(handlersList)) {
                System.out.println("ERROR: not found handler for " + eventClass);
                return;
            }
            for (AbstractEventHandler<Event> eventHandler : handlersList) {
                try {
                    eventHandler.handle(event);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("ERROR: event handling was failed for: " + event);
                }
            }
        }
    }
}
