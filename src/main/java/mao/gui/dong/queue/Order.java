package mao.gui.dong.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/28 下午2:10
 */
public class Order implements Delayed {
    private int orderId;
    private String name;
    private long overDueTime;

    @Override
    public long getDelay(TimeUnit unit) {
        return overDueTime-System.currentTimeMillis();
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.DAYS.toHours(1));
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order(int orderId, String name) {
        this.orderId = orderId;
        this.name = name;
        this.overDueTime= System.currentTimeMillis()+30000;
    }
}
