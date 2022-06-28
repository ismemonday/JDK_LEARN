package mao.gui.dong.mydata.data_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyQueue{
    public static void main(String[] args) {
        int a=1;
        LinkedBlockingQueue<Object> lin = new LinkedBlockingQueue<>();
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
        ArrayBlockingQueue<Integer> arrQueue = new ArrayBlockingQueue<Integer>(3);
        queue.add(11);
        //ConcurrentMap
        arrQueue.add(1);
        arrQueue.add(2);
        arrQueue.add(3);
        //arrQueue.add(4);
        System.out.println(arrQueue.peek());
        System.out.println(arrQueue.poll());
        System.out.println(arrQueue.size());
        arrQueue.add(4);
        System.out.println(arrQueue.peek());

        /*queue.add(1);
        queue.add(2);
        System.out.println(queue.size());
        System.out.println(queue.peek());*/
    }
}
