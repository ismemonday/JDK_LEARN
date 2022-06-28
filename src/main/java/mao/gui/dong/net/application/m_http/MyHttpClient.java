package mao.gui.dong.net.application.m_http;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.spi.CharsetProvider;
import java.util.List;
import java.util.Map;


/**
 * @author maoguidong
 */
public class MyHttpClient {
    public static void main(String[] args) throws IOException {
       httpPost();
       cookie();
    }

    private static void cookie() {
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();
        List<HttpCookie> cookies = cookieStore.getCookies();
        //cookieManager.put("", "");


    }


    /**
     * 通过java原生的http协议（发送post请求给tcp/ip然后获取tcp/ip的返回的信息）
     * 请求格式和响应格式有要求
     */
    private static void httpPost() throws IOException {
        URL url = new URL("http","52.82.28.14",8001,"/mao.txt");
        /**
         * 根据URL构建中的protocol中的参数不同
         * openConnection()获取的URLConnection也不同
         * 有HttpURLConnection，FtpURLConnection(整合了FileURLConnection,JarURLConnection)(注释是sun.net.www.protocol包下)
         * file访问本地计算机中的文件
         * URL中源码
         *  // Avoid using reflection during bootstrap
         *             switch (protocol) {
         *                 case "file":
         *                     return new sun.net.www.protocol.file.Handler();
         *                 case "jar":
         *                     return new sun.net.www.protocol.jar.Handler();
         *                 case "jrt":
         *                     return new sun.net.www.protocol.jrt.Handler();
         *             }
         */
        URLConnection urlConnection = url.openConnection();
        HttpURLConnection httpConnect=(HttpURLConnection) urlConnection;
        byte[] bytes=new byte[1024];
        //这是自定义的请求参数
        httpConnect.setRequestProperty("name", "maoguidong");
        httpConnect.setRequestProperty("age", "18");
        //自定义请求方法
        httpConnect.setRequestMethod("GET");
        Map<String, List<String>> headerFields = httpConnect.getHeaderFields();
        InputStream inputStream = httpConnect.getInputStream();
        int read = inputStream.read(bytes);
        if(read!=-1){
            System.out.println("获取的数据是："+new String(bytes, 0, read, Charset.forName("GBK")));
        }
    }
}
