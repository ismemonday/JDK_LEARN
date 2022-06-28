package mao.gui.dong.design23.component;

/**
 * @author maoguidong
 */
public class ComponentTest {
    public static void main(String[] args) {
        Composite c0 = new Composite();
        Composite c1 = new Composite();
        Leaf l1 = new Leaf("1");
        Leaf l2 = new Leaf("2");
        Leaf l3 = new Leaf("3");
        c0.add(l1);
        c0.add(c1);
        //c1.add(l2);
        //c1.add(l3);
        c0.operation();
    }
}
