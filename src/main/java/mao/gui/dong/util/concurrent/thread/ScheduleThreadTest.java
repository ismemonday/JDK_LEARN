package mao.gui.dong.util.concurrent.thread;

import java.time.LocalDateTime;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class ScheduleThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ScheduleThreadTest lock = new ScheduleThreadTest();
       /* new Thread(()->{
            synchronized (lock){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
        while (true){
            System.out.println(LocalDateTime.now().toString()+"good");
                System.out.println(LocalDateTime.now().toString()+"获取到锁啦");
                lock.wait(5000);
                System.out.println(LocalDateTime.now().toString()+"等待完成");
        }
        //Predicate
    }
}
