package mao.gui.dong.myconcurrent;

import java.util.concurrent.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyThreadPool extends ThreadPoolExecutor {
    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(1);

        /*schedule.scheduleAtFixedRate(()->{
            System.out.println("scheduleAtFixedRate");
        }, 0, 3,TimeUnit.SECONDS );*/


        /*schedule.scheduleWithFixedDelay(()->{
            System.out.println("scheduleWithFixDelay");
        },0,10,TimeUnit.SECONDS);*/

        FutureTask<Integer> test = new FutureTask<Integer>(() -> {
            System.out.println("test");
            return 1;
        });
        try {
            test.run();
            Integer integer = test.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
