package mao.gui.dong.log.faceJcl;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/11 下午8:10
 */
public class SubSysLog4jTest {
    @Test
    public void testLogTimeCast(){
        long start = System.currentTimeMillis();
        slf4Test();
        long end = System.currentTimeMillis();
        System.out.println("花费时间" +(end - start));
    }

    private void slf4Test() {
        Logger log=Logger.getLogger("test");
        for (int i = 0; i < 100000; i++) {
            log.info("hello julllll");
        }
    }
}
