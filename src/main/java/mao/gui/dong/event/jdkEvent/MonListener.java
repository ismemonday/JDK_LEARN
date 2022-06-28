package mao.gui.dong.event.jdkEvent;


import java.util.EventObject;

/**
 * @author maoguidong
 */
public class MonListener implements MyEventListener {

    @Override
    public void onEvent() {
        System.out.println("妈妈开始做饭");
    }
}
