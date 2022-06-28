package mao.gui.dong.event.jdkEvent;


import java.util.EventListener;
import java.util.EventObject;

/**
 * @author maoguidong
 */
public class SonListener implements MyEventListener {

    @Override
    public void onEvent() {
        System.out.println("儿子开始做作业");
    }
}
