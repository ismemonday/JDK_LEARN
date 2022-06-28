package mao.gui.dong.design23.component;

/**
 * @author maoguidong
 * 组合模式的抽象构件
 */
 abstract class Component {
    public void add(Component component) {}

    public void remove(Component component){}

    public Component getChildren(int i){return null;}

    public void operation(){};

}
