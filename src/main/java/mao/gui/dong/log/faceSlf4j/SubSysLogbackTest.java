package mao.gui.dong.log.faceSlf4j;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * //480ms
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/11 下午8:09
 */
public class SubSysLogbackTest {
    @Test
    public void testLogTimeCast(){
        long start = System.currentTimeMillis();
            logbackTest();
        long end = System.currentTimeMillis();
        System.out.println("花费时间" +(end - start));
    }


    private void logbackTest() {
        Logger log=Logger.getLogger("test");
        org.slf4j.Logger logger = LoggerFactory.getLogger(SubSysLogbackTest.class);
        for (int i = 0; i < 100000; i++) {
            logger.info("hello julllll");
        }
    }
}
