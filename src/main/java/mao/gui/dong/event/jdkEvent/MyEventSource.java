package mao.gui.dong.event.jdkEvent;

import java.util.HashSet;

/**
 * @author maoguidong
 */
public class MyEventSource {
    private HashSet<MyEventListener> eventListeners;

   /**
    * 1.给事件源添加监听器
    */
    public void subscribe(MyEventListener listener){
        if(eventListeners==null){
            eventListeners=new HashSet<>();
        }
        eventListeners.add(listener);
    }

    /**
     * 2.激活爸爸回来
     */
    public void dadaBack(){
        DaBackEvent daBackEvent = new DaBackEvent(this,"爸爸回来啦");
        System.out.println(daBackEvent.getMsg());
        this.onEvent();
    }

    /**
     * 3.激活爸爸出去
     */
    public void dadaOut(){
        DaBackEvent daBackEvent = new DaBackEvent(this,"爸爸出去啦啦");
        System.out.println(daBackEvent.getMsg());
        this.onEvent();
    }
    /**
     * 触发事件
     */
    public void onEvent(){
        for (MyEventListener eventListener : eventListeners) {
            eventListener.onEvent();
        }
    }
}
