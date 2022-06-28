package mao.gui.dong.jvm.reference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class WeakReferenceTest{
    public static void main(String[] args) {
        //new WeakReferenceTest().testWeakReference();
        weakTest();
    }


    /**
     * 弱引用测试
     */
    private static void weakTest() {
        Object o1=new Object();
        WeakReference<Object> wr1 = new WeakReference<>(o1);
        o1=null;
        System.out.println(o1==wr1.get()&&o1==null);//false
        System.gc();
        System.out.println(o1==wr1.get()&&o1==null);//true
    }

    private synchronized void testWeakReference() {
        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
        //String key = "weak";
        // 刚开始写成了上边的代码
        //思考一下，写成上边那样会怎么样？ 那可不是引用了
        String key = new String("weak");
        String value = "map";
        map.put(key, value);
        System.out.println(map);
        //去掉强引用
        key = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }
}
