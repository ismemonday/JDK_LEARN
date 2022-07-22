package mao.gui.dong.juc.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/22 上午10:43
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            System.out.println("good");
            LockSupport.park();
            return 1;
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.get());
    }
}
