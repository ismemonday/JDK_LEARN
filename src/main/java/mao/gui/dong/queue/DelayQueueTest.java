package mao.gui.dong.queue;

import java.util.concurrent.DelayQueue;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/28 下午2:10
 */
public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue<Order> orders = new DelayQueue<>();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orders.add(new Order(i+1, "订单"+i));
        }
        System.out.println("数据填充完成");
        for (;orders.size()>0;){
            Order poll = orders.poll();
            if(poll!=null){
                System.out.println(poll.getName());
            }
        }
    }
}
