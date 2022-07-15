package mao.gui.dong.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/28 下午8:48
 */
public class BlockTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Order> orders = new ArrayBlockingQueue<>(10);
        //poll() --立刻返回
        //poll(timeout) --超时返回
        //tack()   --阻塞
        new Thread(()->{
            try {
                Order take = orders.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("拿到数据");
        },"线程1").start();
        System.out.println("11");
        Thread.sleep(10000);
        orders.add(new Order(1, "1"));
    }
}
