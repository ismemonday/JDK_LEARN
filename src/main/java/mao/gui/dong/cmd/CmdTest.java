package mao.gui.dong.cmd;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class CmdTest {
    public static void main(String[] args) {
        String dirPath = System.getProperty("user.dir");
        try {
            Process exec = Runtime.getRuntime().exec("sh "+dirPath+"/src/dist/stop.sh");
            InputStream inputStream = exec.getInputStream();
            byte[] b=new byte[128];
            StringBuilder stringBuilder = new StringBuilder();
            while (inputStream.read(b)!=-1){
                stringBuilder.append(new String(b));
            }
            System.out.println("获取的结果是：\n" + stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
