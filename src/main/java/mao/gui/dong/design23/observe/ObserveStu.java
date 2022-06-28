package mao.gui.dong.design23.observe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class ObserveStu {
    private String name;
    private PropertyChangeSupport support=new PropertyChangeSupport(this);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        support.firePropertyChange("name", this.name, name);
        this.name = name;
    }

    public void addListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public ObserveStu(String name) {
        this.name = name;
        this.support=support;
        addListener(new PropertyChangeListener1());
        addListener(new PropertyChangeListener2());
    }


}
