package mao.gui.dong.myconcurrent.concurentDesign;

import java.util.concurrent.locks.LockSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/30 下午1:49
 */
public class ThreadParkTest {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                System.out.println("t1 start to sleep");
                Thread.sleep(10000);
                System.out.println("t1 wake up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        Thread t2 = new Thread(() -> {
            LockSupport.park();
        }, "t2");
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t2);
    }
}
