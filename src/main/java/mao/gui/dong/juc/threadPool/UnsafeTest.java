package mao.gui.dong.juc.threadPool;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 上午9:40
 */
public class UnsafeTest {
    private static Unsafe theUnsafe=null;
    static {
        Unsafe tem=null;
        try {
            Field fileSafe = Unsafe.class.getDeclaredField("theUnsafe");
            fileSafe.setAccessible(true);
            tem= (Unsafe) fileSafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        theUnsafe=tem;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        theUnsafe.park(false, 0);
    }
}
