package eventloop.api;

public interface EventHandler<T extends Event> {
    void handle(T event);
}
