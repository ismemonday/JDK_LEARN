package mao.gui.dong.log.faceSlf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        Logger log = LoggerFactory.getLogger(SubSysLog4jTest.class);
        for (int i = 0; i < 100000; i++) {
            log.info("hello julllll");
        }
    }
}
