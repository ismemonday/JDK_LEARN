package mao.gui.dong.design23.adapter;

/**
 * @author maoguidong
 * 显示器
 */
public class ComputerDisplay {
   private String inType="typec";

    public void show(String msg,String outType){
        if(inType.equals(outType)){
            System.out.println("要展示在显示屏上的内容::"+msg);
        }else {
            System.out.println("当前接口不配置");
        }

    }
}
