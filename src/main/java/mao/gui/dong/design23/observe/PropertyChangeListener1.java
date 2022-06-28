package mao.gui.dong.design23.observe;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class PropertyChangeListener1 implements PropertyChangeListener {
    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("getNewValue:"+evt.getNewValue());
        System.out.println("getOldValue:"+evt.getOldValue());
        System.out.println("getPropertyName:"+evt.getPropertyName());
    }
}
