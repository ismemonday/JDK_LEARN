package mao.gui.dong.design23.component;

/**
 * @author maoguidong
 * 组合模式的树叶结构
 */
public class Leaf extends Component{
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + ":被访问！");
    }
}
