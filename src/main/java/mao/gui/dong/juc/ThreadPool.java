package mao.gui.dong.juc;

import lombok.Data;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/22 下午2:30
 */
@Data
public class ThreadPool implements Executor {
    private int poolState=0;
    private AtomicInteger workThreads=new AtomicInteger(0);
    private volatile int corePollSize;
    private volatile int maxPollSize;
    private volatile int keepAliveSeconds;
    private static BlockingQueue<Runnable> tasks;

    @Override
    public void execute(Runnable command) {
        if(command==null) {
            throw new NullPointerException();
        }
        boolean full=tasks.remainingCapacity()==0;
        if(full){
            createNoCoreThread(command);
            return;
        }
        addTask(command);
        if (workThreads.get()==0) {
            createThreadRun();
            return;
        }
        if(workThreads.get()<corePollSize){
            createThreadRun();
            return;
        }

    }

    private void createNoCoreThread(Runnable command) {
        new Thread(command,"no-core-pool-thread-"+workThreads.addAndGet(1)).start();
    }

    /**
     * 创建线程并
     */
    private synchronized void createThreadRun() {
        new Thread(()->{runTask();},"pool-thread-"+workThreads.addAndGet(1)).start();
    }

    private void runTask() {
        for (;;){
            Runnable poll = tasks.poll();
            if(poll!=null){
                poll.run();
            }
        }
    }

    private void addTask(Runnable command) {
        tasks.add(command);
    }

    private static ThreadPool open(int corePollSize,int maxPollSize,int keepAliveSecond,BlockingQueue<Runnable> blockingDeque) {
        ThreadPool threadPool = new ThreadPool();
        threadPool.corePollSize=corePollSize;
        threadPool.maxPollSize=maxPollSize;
        tasks=blockingDeque;
       return threadPool;
    }


    public static void main(String[] args) {
        //standardPoolTest();
        myStandardPoolTest();

    }

    private static void myStandardPoolTest() {
        ThreadPool poll= ThreadPool.open(2,5,5, new ArrayBlockingQueue<Runnable>(10));
        AtomicInteger tem = new AtomicInteger(0);
        for (int i = 0; i < 15; i++) {
            poll.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"线程执行"+tem.getAndAdd(1));
            });
        }
    }

    private Future<?> submit(Runnable runnable) {
        return new FutureTask<>(runnable, null);
    }

    private <T> Future<T> submit(Runnable runnable,T result) {
        return new FutureTask<>(runnable, result);
    }

    private <V>Future<V> submit(Callable<V> callable) {
        return new FutureTask<V>(callable);
    }


    private static void standardPoolTest() {
        ThreadPoolExecutor execute = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(30), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 100; i++) {
            int tem=i;
            execute.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"线程执行"+tem);
            });
        }
    }

    private final class Worker implements Runnable{
        private Runnable runnable;
        public Worker(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            runnable.run();
        }
    }

}
