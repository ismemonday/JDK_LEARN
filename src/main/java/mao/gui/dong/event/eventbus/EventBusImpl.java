package mao.gui.dong.event.eventbus;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author maoguidong
 */
public class EventBusImpl implements EventBus{
    private final Set<EventHandler> listeners = new CopyOnWriteArraySet<>();
    /**
     * 事件处理
     * @param event :事件对象
     */
    @Override
    public void onEvent(Object event) {
        for (EventHandler listener : listeners) {
            listener.onEvent(event);
        }
    }

    @Override
    public void subscribe(EventHandler handler) {

    }

    @Override
    public void unsubscribe(EventHandler handler) {

    }
}
