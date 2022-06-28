package mao.gui.dong.util.concurrent.thread;

import java.util.concurrent.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyConcurrentThread {
    public static void main(String[] args) {
        //createThread();
        //threadPoll();
        //List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        //double a=0.0001;
        //double v = (Math.sqrt(Math.sin(a) + 4) - 2) / Math.log(1 + a);
        double x=0.000001;
        System.out.println(Math.pow((2*x+2), 2));


    }

    /**
     * 线程池的运用
     */
    private static void threadPoll() {
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1, 10, 10, TimeUnit.MILLISECONDS, null);
        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(2);
        threadPoolExecutor.scheduleAtFixedRate(()->{
            System.out.println("我被执行了");
        }, 0, 2, TimeUnit.SECONDS);
        threadPoolExecutor.shutdown();
        FutureTask<Integer> hello = new FutureTask<>(() -> {
            System.out.println("hello");
            return null;
        });
        //System.out.println(hello.get());
    }

    /**
     * 创建线程的几种方式
     */
    private static void createThread() {
        //1.继承Thread类
        new MyThread().start();
        //2.实现Runnable接口
        new Thread(()->{
            System.out.println("实现runnable");
        }).start();
        //3.实现callable
        MyCallable myCallable = new MyCallable();
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future submit = executorService.submit(myCallable);
            executorService.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("3.实现callable");
        //4.实现future
        FutureTask<Integer> future = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                System.out.println("Future的运行");
                return 1;
            }
        });
        new Thread(future).start();
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("4.实现future");
        //5.spring的@Async
        //6.线程池
        Executors.newSingleThreadExecutor();

    }
}

class MyCallable implements Callable{

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
        System.out.println("callable");
        return 1;
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("继承Thread");
    }
}