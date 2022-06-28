package mao.gui.dong.design23.build;

/**
 * @author maoguidong
 * 具体的建造者
 */
public class ConcreteBuilder extends Builder{
    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuildA("建造地基");
    }

    @Override
    void buildB() {
        product.setBuildB("铺垫钢筋");
    }

    @Override
    void buildC() {
        product.setBuildC("设置木板");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
