package mao.gui.dong.event.eventbus;

/**
 * @author maoguidong
 * 事件处理器，可理解为事件监听
 */
public interface EventHandler {
    /**
     * 事件处理
     * @param event:事件对象
     */
    void onEvent(Object event);
}
