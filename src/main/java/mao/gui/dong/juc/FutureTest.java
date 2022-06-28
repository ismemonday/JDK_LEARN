package mao.gui.dong.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/22 上午10:43
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(()->{
            System.out.println("good");
            return 1;
        });
        futureTask.run();
        System.out.println(futureTask.get());
    }
}
