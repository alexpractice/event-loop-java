package example.urlchecking;

import eventloop.api.Event;

public class UrlCheckingEvent implements Event {
    private final String url;

    public UrlCheckingEvent(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

    @Override
    public String toString() {
        return "UrlCheckingEvent{" +
                "url='" + url + '\'' +
                '}';
    }
}
