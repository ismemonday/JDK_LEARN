package mao.gui.dong.design23.event;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyBean {
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeSupport(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    private String value;

    public String getValue() {
        return this.value;
    }

    public void setValue(String newValue) {
        String oldValue = this.value;
        this.value = newValue;
        this.pcs.firePropertyChange("value", oldValue, newValue);
    }

    public static void main(String[] args) {
        MyBean myBean = new MyBean();
        myBean.addPropertyChangeSupport(new PropertyChangeListener(){
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                myBean.setValue(String.valueOf(Math.random()));
            }
        });
        myBean.setValue("hello");
    }
}
