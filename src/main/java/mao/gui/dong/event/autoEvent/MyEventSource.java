package mao.gui.dong.event.autoEvent;

import java.util.EventListener;
import java.util.HashSet;

/**
 * @author maoguidong
 */
public class MyEventSource implements MyEventListener {
    private HashSet<MyEventListener> listeners;

    public void subscribe(MyEventListener listener){
    if(listeners==null){listeners=new HashSet<MyEventListener>();}
    listeners.add(listener);
    }

    public void fireOpen(){
        System.out.println("触发开门事件=---------------");
        MyEvent myEvent = new MyEvent();
        myEvent.setEventType(MyEvent.EventType.OPEN);
        onEvent(myEvent);
    }

    public void fireClose(){
        System.out.println("触发关门事件-------------------");
        MyEvent myEvent = new MyEvent();
        myEvent.setEventType(MyEvent.EventType.CLOSE);
        onEvent(myEvent);
    }

    @Override
    public void onEvent(MyEvent event) {
        try {
            for (MyEventListener listener : listeners) {
                listener.onEvent(event);
            }
        }catch (Exception e){
            System.out.println("当前没有监听者");
        }

    }
}
