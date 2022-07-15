package mao.gui.dong.pattern;

import mao.gui.dong.spring.event.MyEventApp;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/12 下午5:21
 */
final public class PatternCl<T> extends MyEventApp {
    private T[] values;


    public T[] getValues() {
        return values;
    }

    public void setValues(T[] values) {
        this.values = values;
    }
}
