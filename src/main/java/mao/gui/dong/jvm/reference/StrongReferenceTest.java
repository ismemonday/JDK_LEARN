package mao.gui.dong.jvm.reference;

import java.util.ArrayList;

/**
 * des 强引用：一般new出来的对象都是强引用
 * @author mgd [maoguidong@standard-robots.com]
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        //即使发生堆内存益处，强引用也不会发生垃圾回收
        //strongTest1();
        //扩展
        strongTest2();
    }

    /**
     * 强引用测试
     */
    private static void strongTest2() {
        Object o1=new Object();
        Object o2=o1;
        o1=null;
        System.out.println(o1 == o2&&o1==null);//false
        System.gc();
        System.out.println(o1==o2&&o1==null);//false
    }

    private static void strongTest1() {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        while (true){
            integers.add(Integer.valueOf(158));
        }
    }
}
