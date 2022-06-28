package mao.gui.dong.design23.originPattern;

import org.springframework.core.convert.Property;

/**
 * @author maoguidong
 */
public class OriginTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        SunWukong wukong1= new SunWukong("大圣1");
        System.out.println(wukong1);
        SunWukong clone = wukong1.clone();
        System.out.println(clone.getName());

    }
}
