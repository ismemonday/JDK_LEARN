package mao.gui.dong.lombda;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/25 下午8:00
 */
public class LombdaTest {
    public static void main(String[] args) {
        int a=15;
       new Thread(){
           @Override
           public void run() {
               int b=a;
               System.out.println(b + 2);
           }
       }.start();
        System.out.println(a);
    }
}
