package mao.gui.dong.annotation.dynamicDataSource.service;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/11 下午3:21
 */

public class SourceOne implements Source{

    @Override
    public void get() {
        System.out.println("get one");
    }
}
