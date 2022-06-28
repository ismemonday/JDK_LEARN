package mao.gui.dong.net.application.m_jar;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author maoguidong
 * 加载本地jar包
 */
public class JarTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("jar:file:/home/maoguidong/.gradle/wrapper/dists/gradle-6.3-bin/8tpu6egwsccjzp10c1jckl0rx/gradle-6.3/lib/gradle-core-6.3.jar!/org/gradle/initialization/converted-types.txt");
        URLConnection urlConnection =  url.openConnection();
    }
}
