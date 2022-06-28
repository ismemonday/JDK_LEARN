package mao.gui.dong.design23.build;

/**
 * @author maoguidong
 * 建造者
 * 为什么要用abstract而不用interface,因为定义的建造者可以不用全部实现建造方法
 */
 abstract class Builder {
     abstract void buildA();
     abstract void buildB();
     abstract void buildC();
     abstract Product getProduct();
}
