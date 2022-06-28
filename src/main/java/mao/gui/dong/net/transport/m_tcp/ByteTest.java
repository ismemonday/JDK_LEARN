package mao.gui.dong.net.transport.m_tcp;

import sun.misc.Unsafe;

import java.nio.ByteBuffer;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/10 下午9:18
 */
public class ByteTest {
    public static void main(String[] args) {
        buffIntTest();
        buffLongTest();
    }

    private static void buffLongTest() {
        int anInt = Unsafe.getUnsafe().getInt(14);
    }

    private static void buffIntTest() {
        ByteBuffer.allocate(10);
    }
}
