package mao.gui.dong.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author maoguidong
 */
public class IoTest {
    public static void main(String[] args) throws IOException {
        byteStream();


    }

    /**
     * 内存流
     * @throws IOException
     */
    private static void byteStream() throws IOException {
        //内存里的字节流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write("hello".getBytes());
        byteArrayOutputStream.write("is".getBytes());
        byteArrayOutputStream.write("byteArray".getBytes());
        byteArrayOutputStream.close();
        String s1 = byteArrayOutputStream.toString();
    }
}
