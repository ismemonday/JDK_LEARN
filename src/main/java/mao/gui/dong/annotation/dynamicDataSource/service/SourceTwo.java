package mao.gui.dong.annotation.dynamicDataSource.service;

import mao.gui.dong.annotation.dynamicDataSource.anno.DynamicDataSource;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/11 下午3:21
 */
@DynamicDataSource("two-class")
public class SourceTwo extends AbstSource{

    @Override
    public void get() {
        System.out.println("get two");
    }
}
