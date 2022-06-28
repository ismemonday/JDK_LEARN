package mao.gui.dong.util.concurrent.thread;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MySingelFactory {
    private static volatile Integer state;
    private MySingelFactory(){}

    public synchronized static Integer getInstance(){
        if(state==null){
            state=new Integer(1);
        }
        return state;
    }

    public  static Integer getInstanceDouble(){
        if(state==null){
            synchronized (MySingelFactory.class){
             state=new Integer(1);
            }
        }
        return state;
    }
}
