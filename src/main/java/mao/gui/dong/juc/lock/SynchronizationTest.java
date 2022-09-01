package mao.gui.dong.juc.lock;


import org.openjdk.jol.info.ClassLayout;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/30 上午9:39
 */
public class SynchronizationTest {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println("main 开始时"+ClassLayout.parseClass(Object.class).toPrintable(o));
        Thread thread = new Thread(() -> {
            synchronized (o) {
                System.out.println("线程1" + ClassLayout.parseClass(Object.class).toPrintable(o));
            }
        }
        );
        thread.start();

        Thread.sleep(2000);
        System.out.println("锁状态"+thread.getState().name());
        System.out.println("线程1结束"+ClassLayout.parseClass(Object.class).toPrintable(o));

        synchronized (o){
            System.out.println("main 锁"+ClassLayout.parseClass(Object.class).toPrintable(o));
        }

        System.out.println("main 结束锁"+ClassLayout.parseClass(Object.class).toPrintable(o));
    }
}
