import eventloop.api.AbstractEventHandler;
import eventloop.api.EventBus;
import eventloop.api.EventLoop;
import eventloop.api.EventPublisher;
import eventloop.impl.EventBusImpl;
import eventloop.impl.EventLoopImpl;
import eventloop.impl.EventPublisherImpl;
import example.chainofevents.IsOddNumberCheckingEvent;
import example.chainofevents.IsOddNumberCheckingEventHandler;
import example.chainofevents.IsOddNumberResultEventHandler;
import example.simple.ReverseSimpleEventHandler;
import example.simple.SimpleEvent;
import example.simple.SimpleEventHandler;
import example.urlchecking.UrlCheckingEvent;
import example.urlchecking.UrlCheckingEventHandler;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        //build
        EventBus eventBus = new EventBusImpl();
        EventLoop eventLoop = new EventLoopImpl(eventBus);
        EventPublisher eventPublisher = new EventPublisherImpl(eventBus);

        AbstractEventHandler simpleEventHandler = new SimpleEventHandler();
        AbstractEventHandler urlCheckingEventHandler = new UrlCheckingEventHandler();
        AbstractEventHandler isOddNumberResultEventHandler = new IsOddNumberResultEventHandler();
        AbstractEventHandler isOddNumberCheckingEventHandler = new IsOddNumberCheckingEventHandler(eventPublisher);
        AbstractEventHandler reverseSimpleEventHandler = new ReverseSimpleEventHandler();

        eventLoop.addEventHandler(simpleEventHandler);
        eventLoop.addEventHandler(urlCheckingEventHandler);
        eventLoop.addEventHandler(isOddNumberResultEventHandler);
        eventLoop.addEventHandler(isOddNumberCheckingEventHandler);
        eventLoop.addEventHandler(reverseSimpleEventHandler);

        eventLoop.start();

        //running
        SimpleEvent simpleEvent = new SimpleEvent("hello world!");
        eventPublisher.publish(simpleEvent);

        IntStream
                .range(12, 1_000)
                .forEach(it ->
                        CompletableFuture.runAsync(() ->
                                eventPublisher.publish(new IsOddNumberCheckingEvent(it))
                        )
                );

        UrlCheckingEvent urlCheckingEventForSuccess = new UrlCheckingEvent("http://ya.ru");
        UrlCheckingEvent urlCheckingEventForFailing = new UrlCheckingEvent("terere");
        eventPublisher.publish(urlCheckingEventForSuccess);
        eventPublisher.publish(urlCheckingEventForFailing);
        eventPublisher.publish(new SimpleEvent("lol"));
    }
}
