package mao.gui.dong.design23.factory.abstractFactory;

/**
 * 抽象工厂模式是抽象方法的升级，升级在产品类别的可以随意扩展
 * @author maoguidong
 */
public interface Farm {
    public Animal newAnimal();
    public Plant newPlant();
}
