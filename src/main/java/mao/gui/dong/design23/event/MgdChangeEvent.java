package mao.gui.dong.design23.event;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MgdChangeEvent {
    private Object oldValue;
    private Object newValue;

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public MgdChangeEvent(Object oldValue, Object newValue) {
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public MgdChangeEvent() {
    }

    @Override
    public String toString() {
        return "MgdChangeEvent{" +
                "oldValue=" + oldValue +
                ", newValue=" + newValue +
                '}';
    }
}
