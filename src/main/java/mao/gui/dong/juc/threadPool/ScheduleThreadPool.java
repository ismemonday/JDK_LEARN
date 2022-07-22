package mao.gui.dong.juc.threadPool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/27 下午2:43
 */
public class ScheduleThreadPool {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(5);
        threadPool.scheduleAtFixedRate(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"hello"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }, 1, 1, TimeUnit.SECONDS);
    }
}
