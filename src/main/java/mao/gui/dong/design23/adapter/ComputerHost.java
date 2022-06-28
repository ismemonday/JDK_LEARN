package mao.gui.dong.design23.adapter;

/**
 * @author maoguidong
 * 这是一个电脑主机
 */
public class ComputerHost {
    private String outType="hdmi";

    private ComputerDisplay display;

    public void show(String msg){
       display.show(msg,outType);
    }

    public ComputerHost(ComputerDisplay display) {
        this.display = display;
    }
}
