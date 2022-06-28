package mao.gui.dong.event.autoEvent;

public class RiceEventListener implements MyEventListener{
    @Override
    public void onEvent(MyEvent event) {
        if(MyEvent.EventType.OPEN==(event.getEventType())){
            System.out.println("饭店开始做饭啦");
        }else{
            System.out.println("饭店开始洗碗啦");
        }
    }
}
