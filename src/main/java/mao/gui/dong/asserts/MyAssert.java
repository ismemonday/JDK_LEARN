package mao.gui.dong.asserts;

import java.util.function.Supplier;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/5/18 上午10:24
 */
public class MyAssert {
    public static void main(String[] args){
        //Assert.assertTrue("你好", false);
//        try {
//            isTrue(false, new RuntimeException("is some of me"));
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
        try {
            isTrue2(false, ()->new RuntimeException("some"));
        }catch (RuntimeException e){
            System.out.println("222");
        }

    }

    public static void isTrue(boolean condition,Throwable throwable) throws Throwable {
        if(!condition){
            throw throwable;
        }
    }

    public  static <X extends Throwable> void isTrue2(boolean expression, Supplier<? extends X> supplier) throws X {
        if (!expression) {
            throw (X)(supplier.get());
        }
    }
}
