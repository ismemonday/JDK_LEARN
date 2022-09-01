package mao.gui.dong.annotation.dynamicDataSource.service;

import java.util.ArrayList;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/11 下午3:26
 */
public class AppTest {
    public static void main(String[] args) {
        Source sourceOne = new SourceOne();
        Source sourceTwo = new SourceTwo();
        Source sourceThree = new SourceThree();
        ArrayList<Source> sources = new ArrayList<>();
        sources.add(sourceOne);
        sources.add(sourceTwo);
        sources.add(sourceThree);

        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(2000);
                    sources.get((int)((Math.random()*100)%(sources.size()))).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
