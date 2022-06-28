package mao.gui.dong.design23.adapter;

/**
 * @author maoguidong
 */
public class AppTest {
    public static void main(String[] args) {
        /**
         * 1.使用原来的方式
         */
        //创建一个显示器（入为typec）
        ComputerDisplay computerDisplay = new ComputerDisplay();
        //创建一个主机链接到显示器（出口为hdmi）
        ComputerHost computerHost = new ComputerHost(computerDisplay);
        //利用主机将消息传递给显示器展示
        computerHost.show("你好啊");

        /**
         * 2.使用适配器模式在不改变原来代码的情况下調整接口
         */
        ComputerDisplay adapter = new Adapter();
        ComputerHost computerHost2 = new ComputerHost(adapter);
        computerHost2.show("你好啊");
    }
}
