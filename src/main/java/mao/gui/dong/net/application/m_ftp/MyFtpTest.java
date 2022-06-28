package mao.gui.dong.net.application.m_ftp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

/**
 * 文件传输协议:ftp
 * @author maoguidong
 *
 */
public class MyFtpTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("ftp://localhost:/home/maoguidong/ideaprojects/JDK_Learn/mao.txt");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        byte[] buf=new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len=0;
        while ((len=inputStream.read(buf))!=-1){
            baos.write(buf, 0, len);
        }
        System.out.println(baos.toString());
    }
}
