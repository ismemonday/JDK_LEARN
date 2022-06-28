package mao.gui.dong.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/21 下午4:14
 */
public class CompleteableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testSupplyAsync();
    }

    private static void testSupplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> hello = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
            return 6;
        });
        hello.whenComplete((a,nu)->{
            System.out.println(a);
        });
        System.out.println("主完了");
        Thread.sleep(6000);
    }

    private static void testRunAsync() {
        CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
        });
        System.out.println("主完了");
    }
}
