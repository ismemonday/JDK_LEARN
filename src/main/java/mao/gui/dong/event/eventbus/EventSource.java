package mao.gui.dong.event.eventbus;

/**
 * @author maoguidong
 * 事件源，提供订阅和取消功能
 */
public interface EventSource {

    void subscribe(EventHandler handler);

    void unsubscribe(EventHandler handler);
}
