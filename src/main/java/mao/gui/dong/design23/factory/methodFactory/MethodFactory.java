package mao.gui.dong.design23.factory.methodFactory;

/**
 * 工厂方法模式
 * 如果是多个类的产品做不同的事情那么简单工厂就不适应
 * @author maoguidong
 */
public interface MethodFactory {
    Message createProduct();
}
