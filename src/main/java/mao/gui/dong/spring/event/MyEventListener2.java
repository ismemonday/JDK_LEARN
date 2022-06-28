package mao.gui.dong.spring.event;

import org.springframework.context.ApplicationListener;


/**
 * @author maoguidong
 */
public class MyEventListener2 implements ApplicationListener<MyEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("监听器2监听到："+event.getMsg());
    }
}
