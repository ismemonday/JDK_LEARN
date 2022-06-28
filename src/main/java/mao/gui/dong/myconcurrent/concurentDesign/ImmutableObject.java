package mao.gui.dong.myconcurrent.concurentDesign;

/**
 * 1-不可变对象
 * 只读当然是线程安全
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/24 上午11:44
 */
public class ImmutableObject {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
