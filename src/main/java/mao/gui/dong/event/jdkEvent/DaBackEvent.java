package mao.gui.dong.event.jdkEvent;

import java.util.EventObject;

/**
 * @author maoguidong
 * da回来了这个事件
 */
public class DaBackEvent extends EventObject {
    private String msg;
    public DaBackEvent(Object source,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
