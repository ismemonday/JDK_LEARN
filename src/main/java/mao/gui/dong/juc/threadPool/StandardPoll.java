package mao.gui.dong.juc.threadPool;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/22 上午11:23
 */
public class StandardPoll {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
        poolExecutor.submit(()->{
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        boolean b = poolExecutor.awaitTermination(6,TimeUnit.SECONDS);
        System.out.println(b);
    }
}
