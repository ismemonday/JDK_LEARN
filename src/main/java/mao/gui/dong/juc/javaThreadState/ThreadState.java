package mao.gui.dong.juc.javaThreadState;

/**
 * jdk线程状态:NEW--RUNNABLE--BLOCKED--WAITING--TIMED_WAITING--TERMINATED
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/22 下午2:14
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{},"t1");
        System.out.println(thread.getName()+":"+thread.getState());
        thread.wait();
        System.out.println(thread.getName()+":"+thread.getState());
        thread.start();
        System.out.println(thread.getName()+":"+thread.getState());
    }
}
