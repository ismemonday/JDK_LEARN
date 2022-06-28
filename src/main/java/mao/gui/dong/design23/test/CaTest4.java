package mao.gui.dong.design23.test;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class CaTest4 extends AbTest3 implements Test1{

    @Override
    public void m1(int a) {
        System.out.println("hello im in Cateest4");
        System.out.println(a);
    }

    public static void main(String[] args) {
        try {
            //throw new RuntimeException("我超时啦");
            System.out.println("不抛出异常");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("最后哟");
        }
    }
}
