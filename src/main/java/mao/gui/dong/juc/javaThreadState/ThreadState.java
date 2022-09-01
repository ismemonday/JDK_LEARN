package mao.gui.dong.juc.javaThreadState;

import java.util.concurrent.locks.LockSupport;

/**
 * jdk线程状态:NEW--RUNNABLE--BLOCKED--WAITING--TIMED_WAITING--TERMINATED
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/22 下午2:14
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.wait(1);
        LockSupport.park();
        LockSupport.unpark(thread);
        thread.join();
        Thread.yield();
        thread.notify();
        thread.notifyAll();

    }
}
