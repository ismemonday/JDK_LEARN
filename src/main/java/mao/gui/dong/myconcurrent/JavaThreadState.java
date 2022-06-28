package mao.gui.dong.myconcurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * java中线程的状态有 7种：NEW,RUNNABLE,BLOCKED,WAITING,TIME_WAITING,TERMINATE
 * linux内核线程的状态有：
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/30 下午1:55
 */
public class JavaThreadState {
    public static void main(String[] args) {
        new JavaThreadState().testBlockStateCpu();
    }

    private void testBlockStateCpu() {
        Object o = new Object();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始创建线程");
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+"抢到了锁");
                    LockSupport.park();
                }
            },"myThread"+i).start();
        }
    }

    /**
     * Wait状态不占用cpu
     */
    private  void testWaitStateCpu() {
        Object o = new Object();
        //先创建一个sleep状态的线程看看cpu消耗
        new Thread(()->{
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        System.out.println("111");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("222");
        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                //让每个线程都抢到锁
                Object ob = new Object();
                synchronized (ob){
                    try {
                        ob.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

    /**
     * SLEEP不消耗cpu
     */
    private static void testSleepStateCpu() {
        //先创建一个sleep状态的线程看看cpu消耗
        new Thread(()->{
            try {
                Thread.sleep(600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 500; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(600000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
