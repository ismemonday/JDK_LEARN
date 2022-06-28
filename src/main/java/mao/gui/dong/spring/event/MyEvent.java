package mao.gui.dong.spring.event;

import org.springframework.context.ApplicationEvent;


/**
 * @author maoguidong
 * 自定义事件
 */
public class MyEvent extends ApplicationEvent {
    private String msg="爸爸回来啦";
    public MyEvent(Object source) {
        super(source);
    }

    public String getMsg() {
        return msg;
    }

}
