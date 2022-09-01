package mao.gui.dong.jvm.string;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/27 下午6:25
 */
public class StringTest {
    public static void main(String[] args) {
        String s = new String("fasfsfsda") + new String("bbbbb");
        System.out.println(s.intern() == s);
        String s2 = new String("fasfsfsda");
        System.out.println(s2.intern() == s2);

    }
}
