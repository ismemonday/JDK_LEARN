package mao.gui.dong.log.faceJcl;

import org.junit.Test;
import org.slf4j.LoggerFactory;

/**
 * 2000ms
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/11 下午8:11
 */
public class SubSysJULTest {
    @Test
    public void testLogTimeCast(){
        long start = System.currentTimeMillis();
        julTest();
        long end = System.currentTimeMillis();
        System.out.println("花费时间" +(end - start));
    }

    private void julTest() {
        org.slf4j.Logger log = LoggerFactory.getLogger(SubSysJULTest.class);
        for (int i = 0; i < 100000; i++) {
            log.info("hello julllll");
        }
    }
}
