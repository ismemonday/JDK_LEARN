package mao.gui.dong.juc.threadPool;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/14 上午9:34
 */
public class MyScheduleThrad extends ScheduledThreadPoolExecutor {
    public MyScheduleThrad(int corePoolSize) {
        super(corePoolSize);
    }


    @Override
    public void execute(Runnable command) {
        new Thread(command,"自定义线程"){
            @Override
            public synchronized void run() {
                for (;;){
                    System.out.println("我不运行你的command");
                    try {
                        wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //LockSupport.parkNanos(1000000000L);
                }

            }
        }.start();
    }



    public static void main(String[] args) {
        MyScheduleThrad myScheduleThrad = new MyScheduleThrad(2);
        myScheduleThrad.execute(()->{
            System.out.println("hello"+Thread.currentThread().getName());
        });

    }
}
