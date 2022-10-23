package eventloop.api;

public interface EventLoop {
    void addEventHandler(AbstractEventHandler<Event> eventHandler);

    void start();
}
