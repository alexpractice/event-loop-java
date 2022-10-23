package eventloop.api;

public interface EventBus {
    void push(Event event);

    Event take();
}
