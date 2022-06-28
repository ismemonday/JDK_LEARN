package mao.gui.dong.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        softRefMemoryEnough();
        System.out.println("==================");
        softRefMemoryNotEnough();
    }

    private static void softRefMemoryEnough() {
        Object o1 = new Object();
        SoftReference<Object> so1 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(so1);
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(so1);
    }

    /**
     * -Xms3m -Xmx3m
     */
    private static void softRefMemoryNotEnough() {
        Object o1 = new Object();
        SoftReference<Object> so1 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(so1);
        o1=null;
        byte[] bytes = new byte[ 1024 * 1024];
        System.gc();
        System.out.println(o1);
        System.out.println(so1);
    }


}
