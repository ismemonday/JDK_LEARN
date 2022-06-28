package mao.gui.dong.event.autoEvent;

/**
 * @author maoguidong
 * 定义了一个事件事件类型有开门和关门
 */
public class MyEvent {
    private EventType eventType;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public enum  EventType {
        OPEN,CLOSE;
    }
}
