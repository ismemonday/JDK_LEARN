package mao.gui.dong.myconcurrent;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/24 上午9:12
 */
public class JstackTest {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(()->{
                synchronized (o){
                    try {
                        Thread.sleep(500000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        },"t1").start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (o){
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}
