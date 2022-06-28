package mao.gui.dong.myconcurrent;

import java.util.logging.Logger;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/8 上午10:27
 */
public class TaskTest {
    private final static Logger log=Logger.getLogger("TaskTest");
    public static void main(String[] args) {
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
//        log.info("开始");
//        executorService.scheduleWithFixedDelay(()->{
//            log.info(Thread.currentThread().getName()+"doSome");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 0, 3, TimeUnit.SECONDS);

        System.out.println(Integer.valueOf("5,6"));
    }
}
