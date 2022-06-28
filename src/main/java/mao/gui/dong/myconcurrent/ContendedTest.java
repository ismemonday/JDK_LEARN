package mao.gui.dong.myconcurrent;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/26 上午9:53
 */
public class ContendedTest {

    private volatile long a=0;
    private long p1,p2,p3,p4,p5;
    private volatile long b=0;

    public static void main(String[] args) throws InterruptedException {

        ContendedTest contendedTest = new ContendedTest();


        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                contendedTest.a++;
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                contendedTest.b++;
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        System.out.println("耗时:"+(end - start));

    }
}
