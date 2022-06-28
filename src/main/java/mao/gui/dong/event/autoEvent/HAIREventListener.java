package mao.gui.dong.event.autoEvent;

public class HAIREventListener implements MyEventListener{
    @Override
    public void onEvent(MyEvent event) {
        if(MyEvent.EventType.OPEN==(event.getEventType())){
            System.out.println("理发店开始理发啦");
        }else{
            System.out.println("饭店开始关门啦");
        }
    }
}
