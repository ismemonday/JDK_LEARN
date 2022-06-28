package mao.gui.dong.event.changeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyChangeListener implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public static void main(String[] args) {
        MyChangeListener myChangeListener = new MyChangeListener();
        myChangeListener.propertyChange(new PropertyChangeEvent("资源名称","ss","11","22"));

    }
}
