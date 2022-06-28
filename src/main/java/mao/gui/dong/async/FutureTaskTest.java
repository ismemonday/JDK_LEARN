package mao.gui.dong.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //从数据库查询到数据
        List<Integer> sqlData=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            sqlData.add(i);
        }
        //初始化线程池
        int corePoolSize=Runtime.getRuntime().availableProcessors()*2;
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(corePoolSize);
        //分组
        //计算
        //汇总


    }
}
