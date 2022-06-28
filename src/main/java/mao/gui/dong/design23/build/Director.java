package mao.gui.dong.design23.build;

/**
 * @author maoguidong
 * 建造者安排建造顺序
 */
public class Director {
    public Product create(Builder builder){
        builder.buildB();
        builder.buildA();
        builder.buildC();
        return builder.getProduct();
    }
}
