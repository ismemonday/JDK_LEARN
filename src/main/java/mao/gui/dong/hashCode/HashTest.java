package mao.gui.dong.hashCode;

import java.nio.charset.Charset;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/5/6 上午11:03
 */
public class HashTest {
    public static void main(String[] args) {
        System.out.println(Byte.valueOf("1").hashCode());
        System.out.println(Boolean.valueOf(false).hashCode());

        System.out.println(Short.valueOf((short) 5).hashCode());
        System.out.println(Charset.forName("utf-8").hashCode());

        System.out.println(Integer.valueOf(15).hashCode());
        System.out.println(Float.valueOf(5.4f).hashCode());

        System.out.println(Long.valueOf(55L).hashCode());
        System.out.println(Double.valueOf(5.62).hashCode());

        System.out.println(String.valueOf(98).hashCode());
    }
}
