package mao.gui.dong.net.transport.m_tcp;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/28 上午9:55
 */
public class NioSocketStateTest {
}

/**
 * 基于epoll的实现
 */
class EpollServer{
    private static Selector selector;
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //默认采用的是epoll的provider
        //ServerSocketChannel ssc = ServerSocketChannel.open();
        //强制使用select或poll（SelectorProvider=>{EPollSelectorProvider，PollSelectorProvider，SelectorProviderImpl}）
        Object tmp = Class.forName("sun.nio.ch.PollSelectorProvider", true,
                ClassLoader.getSystemClassLoader()).getDeclaredConstructor().newInstance();
        SelectorProvider provider = (SelectorProvider)tmp;
        ServerSocketChannel ssc = provider.openServerSocketChannel();
        selector = provider.openSelector();
        ssc.configureBlocking(false);
        ssc.bind(new InetSocketAddress(8888));
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            Set<SelectionKey> keys = selector.keys();
            System.out.println("当前epoll注册的事件：" + keys.size());
            while (selector.select()>0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()) {
                        System.out.println("有一个客户端连接了。。。");
                        acceptHandle(selectionKey);
                    } else if (selectionKey.isReadable()) {
                        readHandler(selectionKey);
                    }
                }
            }
        }
    }

    private static void readHandler(SelectionKey curKey) throws IOException {
        SocketChannel sc = (SocketChannel) curKey.channel();
        ByteBuffer buff = ByteBuffer.allocate(64);
        int len=0;
        while ((len=sc.read(buff))>0){
            System.out.println(new String(buff.array(), 0, len));
            buff.flip();
            sc.write(buff);
            buff.compact();
        }
        if(len==-1){
            sc.close();
        }
    }

    private static void acceptHandle(SelectionKey curKey) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) curKey.channel();
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
    }

}

/**
 * 基于select和poll的实现
 */
class NioServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel open = ServerSocketChannel.open();
        ArrayBlockingQueue<SocketChannel> sockets = new ArrayBlockingQueue<>(100);
        open.configureBlocking(false);
        open.bind(new InetSocketAddress(6666));
        ByteBuffer allocate = ByteBuffer.allocate(64);
        while (true) {
            Thread.sleep(1000);
            SocketChannel accept = open.accept();
            if (accept != null) {
                System.out.println("接受到客户端链接" + accept);
                accept.configureBlocking(false);
                sockets.add(accept);
            }

            for (SocketChannel socket : sockets) {
                int read = socket.read(allocate);
                if (read == -1) {
                    socket.close();
                    sockets.remove(socket);
                }
                if (read > 0) {
                    allocate.clear();
                    System.out.println("接受到客户端：" + socket + "消息：" + new String(allocate.array()));
                }
            }
        }
    }
}

class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socket = SocketChannel.open(new InetSocketAddress("localhost", 8858));
        System.out.println("客户端链接上了");
        //socket.write(ByteBuffer.wrap("hello".getBytes()));
        ByteBuffer byteBuffer =ByteBuffer.allocate(12000);
        while (true){
            try {
                Thread.sleep(100);
                socket.isConnected();
                socket.read(byteBuffer);
                byteBuffer.flip();
                System.out.println("数据"+new String(byteBuffer.array(), 0, byteBuffer.position()));
                byteBuffer.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test{
    public static void main(String[] args) throws CharacterCodingException {
        ByteBuffer buff = ByteBuffer.wrap(new byte[]{(byte) 12, (byte) 11, (byte) 1, (byte) 2, (byte) 6});
        System.out.println(Charset.forName("UTF-8").newDecoder().decode(buff).toString());
    }
}