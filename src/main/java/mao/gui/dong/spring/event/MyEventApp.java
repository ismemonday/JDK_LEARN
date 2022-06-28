package mao.gui.dong.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

/**
 * @author maoguidong
 */
public class MyEventApp {

    public static void main(String[] args) {
       /* ApplicationContext context = new ClassPathXmlApplicationContext("event_bean.xml");
        ApplicationEventMulticaster bean = context.getBean(ApplicationEventMulticaster.class);
        ApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
        applicationEventMulticaster.addApplicationListener(new MyEventListener());
        applicationEventMulticaster.addApplicationListener(new MyEventListener2());
        applicationEventMulticaster.multicastEvent(new MyEvent(""));
        Assert.notNull(bean, "ben not be null");*/
        springEvent();
    }

    private static void springEvent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("event_bean.xml");
        context.publishEvent(new MyEvent(""));
    }
}
