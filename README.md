# Event Loop

Simple event loop for processing custom application events 
 
#####1. Configure Event Publisher and Event Loop.
```java
EventBus eventBus = new EventBusImpl();
EventLoop eventLoop = new EventLoopImpl(eventBus);
EventPublisher eventPublisher = new EventPublisherImpl(eventBus);

eventLoop.addEventHandler(simpleEventHandler);
eventLoop.addEventHandler(urlCheckingEventHandler);
eventLoop.addEventHandler(isOddNumberResultEventHandler);
eventLoop.addEventHandler(isOddNumberCheckingEventHandler);
```
#####2. Start Event Loop after configuring
```java
eventLoop.start();
```
#####3. Publish events through the Event Publisher
```java
SimpleEvent simpleEvent = new SimpleEvent("hello world!");
eventPublisher.publish(simpleEvent);
```
You may see the working example into Test.java

I'll publish thats event-loop library in maven central repository later

 

