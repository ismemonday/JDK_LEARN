package mao.gui.dong.net.transport.m_tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/3 下午2:07
 */
public class ByteArrayOutPutSt {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(6);
        baos.write("hell".getBytes());
        baos.write("hell".getBytes());
        System.out.println(baos.toByteArray());
    }
}
