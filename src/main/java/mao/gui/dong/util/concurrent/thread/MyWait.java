package mao.gui.dong.util.concurrent.thread;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class MyWait {
    public static void main(String[] args) {
        MyWait myWait = new MyWait();
        int[] consumers={1,0,1,1,0,1,0,0,1,1,1,1};
        new Thread(()->{
            try {
                for (int consumer : consumers) {
                   if(consumer==-1){

                   }
                }
                myWait.willWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程" + Thread.currentThread().getName()+"执行完了");
       }).start();
        new Thread(()->{
            try {
                myWait.willWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程" + Thread.currentThread().getName()+"执行完了");
        }).start();
        System.out.println("主线程执行完了");
    }


    private void willWait() throws InterruptedException {
        wait();
    }

    private void willWait(long millionSeconds) throws InterruptedException {
        wait(3000);
    }

    private void doNotify(){
        notify();
       Thread.interrupted();

    }
}
