package mao.gui.dong.myconcurrent.concurentDesign;

/**
 * TWO-PHASE-TERMINATION 两阶段终止
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/24 上午11:22
 */
public class TwoSpaceStop {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "活着");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, "t1");
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }

}
