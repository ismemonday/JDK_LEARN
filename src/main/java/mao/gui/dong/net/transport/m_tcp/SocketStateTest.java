package mao.gui.dong.net.transport.m_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 *
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/30 下午2:47
 */
public class SocketStateTest {
    public static void main(String[] args) throws IOException {
        //BIO  Server and client
        ServerSocket ss = new ServerSocket();
        Socket s = new Socket();

        //NIO Server and client
        ServerSocketChannel ssc = ServerSocketChannel.open();
        SocketChannel sc = SocketChannel.open();
        int read = sc.read(ByteBuffer.allocate(10));

        //Socket state
        //ST_UNCONNECTED = 0;
        //private static final int ST_CONNECTIONPENDING = 1;
        //private static final int ST_CONNECTED = 2;
        //private static final int ST_CLOSING = 3;
        //private static final int ST_KILLPENDING = 4;
        //private static final int ST_KILLED = 5;

        //文件描述符号



    }

}
