package mao.gui.dong.design23.test;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public abstract class AbTest3 implements Test2{
    @Override
    public int m2(int a) {
        m1(a);
        return 3;
    }
}
