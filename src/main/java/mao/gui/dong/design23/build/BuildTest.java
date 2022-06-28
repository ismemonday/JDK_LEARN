package mao.gui.dong.design23.build;

/**
 * @author maoguidong
 */
public class BuildTest {
    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        Director director = new Director();
        Product product = director.create(concreteBuilder);
        System.out.println(product.toString());
    }
}
