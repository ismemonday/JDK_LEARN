package mao.gui.dong.net.application.m_file;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author maoguidong
 * 加载本地File文件
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("file:/home/maoguidong/.gradle/wrapper/dists/gradle-6.3-bin/8tpu6egwsccjzp10c1jckl0rx/gradle-6.3/lib/gradle-core-6.3.jar");
        URLConnection urlConnection = url.openConnection();
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
    }

    /**
     * 通过java原生的file协议获取本地计算机中的文件资源
     */
    private static void fileGet() throws IOException {
        URL url = new URL("file://localhost/home/maoguidong/ideaprojects/JDK_Learn/mao.txt");
        /**
         * 由于协议是file协议，所以openConnection()获取到的URLConnection为FtpURLConnection
         */
        URLConnection urlConnection = url.openConnection();
        //设置链接超时时间
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println("文件中的内容是" + s);
    }
}
