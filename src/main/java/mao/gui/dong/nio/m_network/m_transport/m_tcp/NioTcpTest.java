package mao.gui.dong.nio.m_network.m_transport.m_tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author maoguidong
 * tcp:套接字协议 socketChannel
 */
public class NioTcpTest {
    public static void main(String[] args) throws IOException {
        //1.选择通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(6666));
        Selector select = Selector.open();
        ssc.configureBlocking(false);
        //ssc.accept();
        ssc.register(select, SelectionKey.OP_ACCEPT);
        while (true){
            select.select(1000);
            Iterator<SelectionKey> iterator = select.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if(selectionKey.isAcceptable()){
                    ssc = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(select, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer allocate = ByteBuffer.allocate(24);
                    channel.read(allocate);
                    byte[] array = allocate.array();
                    System.out.println(new String(array, 0, array.length));
                }
            }
        }
    }

}
