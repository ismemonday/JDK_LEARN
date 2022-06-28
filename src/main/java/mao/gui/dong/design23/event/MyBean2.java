package mao.gui.dong.design23.event;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyBean2 {

    private String value;

    private final MgdListener listener;

    public MyBean2(MgdListener listener) {
        this.listener = listener;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String newValue) {
     listener.doSomeChanged(new MgdChangeEvent(this.value,newValue));
     this.value=newValue;
    }

    public static void main(String[] args) {
        MyBean2 myBean = new MyBean2(new MgdListener() {
            @Override
            public void doSomeChanged(MgdChangeEvent event) {
                System.out.println(event);
            }
        });
      myBean.setValue("hello");
        myBean.setValue("good");
    }
}
