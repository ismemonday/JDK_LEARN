package mao.gui.dong.net.application.m_mao;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @author maoguidong
 * 自定义协议：mao
 */
public class  MaoTest {
    public static void main(String[] args) throws IOException {
        MaoStreamHandlerFactory maofactory = new MaoStreamHandlerFactory();
        URL.setURLStreamHandlerFactory(maofactory);
        URL mao = new URL("mao", "52.82.28.14", 8001, "/mao.txt");
        URLConnection maoConnect = mao.openConnection();
        byte[] bytes=new byte[1024];
        InputStream inputStream = maoConnect.getInputStream();
        int read = inputStream.read(bytes);
        if(read!=-1){
            System.out.println("获取的数据是："+new String(bytes, 0, read, Charset.forName("GBK")));
        }
    }
}
