package mao.gui.dong.design23.originPattern;

/**
 * @author maoguidong
 * 原型的实体类
 */
public class SunWukong extends Object implements Cloneable{
    private String name;

    public SunWukong(String name) {
        this.name=name;
    }

    @Override
    protected SunWukong clone() throws CloneNotSupportedException {
        return (SunWukong)super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
