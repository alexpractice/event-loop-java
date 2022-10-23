package eventloop.api;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractEventHandler<T extends Event> implements EventHandler<T> {
    protected Class<T> processingEventClass;

    protected AbstractEventHandler() {
        this.processingEventClass = (Class<T>)
                ((ParameterizedType)getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0];
    }

    public Class<T> getProcessingEventClass() {
        return this.processingEventClass;
    }
}
