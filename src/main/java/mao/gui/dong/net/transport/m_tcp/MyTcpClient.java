package mao.gui.dong.net.transport.m_tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author maoguidong
 */
public class MyTcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(6666));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello is me client".getBytes());
        outputStream.flush();
        outputStream.close();
        socket.close();
        //RestTemplate
        SocketChannel sc = SocketChannel.open(new InetSocketAddress(222));
        Selector selector = Selector.open();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            selector.selectedKeys().iterator();
        }
    }
}
