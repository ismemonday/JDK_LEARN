package mao.gui.dong.design23.adapter;

/**
 * @author maoguidong
 */
public class Adapter extends ComputerDisplay{
    @Override
    public void show(String msg, String outType) {
        outType="typec";
        super.show(msg, outType);
    }
}
