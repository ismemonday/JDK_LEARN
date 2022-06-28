package mao.gui.dong.myconcurrent.concurentDesign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GUARDED-SUSPENSION 保护性暂挂 类似于join的实现
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/24 上午11:46
 */

public class GuardedSuspension {
    static Logger log = LoggerFactory.getLogger(GuardedSuspension.class);


    public static void main(String[] args) {
        MyFutureSleep myFuture = new MyFutureSleep();
        log.info("主县城开始任务");
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                log.info("t1,5s后完成");
                myFuture.setObj(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        for (int i = 0; i < 1000; i++) {
             new Thread(() -> {
                 myFuture.get(0);
                 log.info("得到结果");
            }, "GET"+i).start();
        }

    }
}

class MyFutureSleep{
    private Object obj;

    /**
     * 设置数据
     * @param obj
     */
    public synchronized void setObj(Object obj){
        this.obj=obj;
    }

    public synchronized Object get(long timeOut){
        if(timeOut<0){
            throw new IllegalArgumentException("timeOut is illegal");
        }
        if(timeOut==0){
            timeOut=Integer.MAX_VALUE;
        }
        //开始时间
        long startTime=System.currentTimeMillis();
        //经过了多长时间
        long now=0;
        //持续时间
        while (obj==null){
            //剩余时间
            long delay=timeOut-now;
            if(delay<0){
                break;
            }
            try {
                 wait(delay);
                 now=System.currentTimeMillis()-startTime;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}

class ExampleJoin{
    static Logger log = LoggerFactory.getLogger(GuardedSuspension.class);
    public static void main(String[] args) {
        log.info("开始加载");
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(4000);
                log.info("视频加载好了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(2000);
                log.info("音频加载好了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            log.info("视频和音频都加载完成了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
