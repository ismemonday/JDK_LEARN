package mao.gui.dong.event.autoEvent;

/**
 * @author maoguidong
 */
public class AutoEventTest {
    public static void main(String[] args) {
        MyEventSource myEventSource = new MyEventSource();
        myEventSource.subscribe(new RiceEventListener());
        myEventSource.subscribe(new HAIREventListener());
        myEventSource.fireOpen();
        myEventSource.fireClose();
    }
}
