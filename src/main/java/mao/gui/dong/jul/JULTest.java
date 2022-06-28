package mao.gui.dong.jul;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/9 下午9:29
 */

public class JULTest {

    @Test
    public void testJUL(){
        Logger log=Logger.getLogger("test");
        log.info("hello jul");

        log.log(Level.WARNING, "warm");
        log.log(Level.FINER, "warm");
        log.severe("servere msg");

    }
}
