package example.urlchecking;

import eventloop.api.AbstractEventHandler;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlCheckingEventHandler extends AbstractEventHandler<UrlCheckingEvent> {
    @Override
    public void handle(UrlCheckingEvent event) {
        try {
            URI uri = new URL(event.url()).toURI();
            System.out.println(event + " processed correctly ");
        } catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
