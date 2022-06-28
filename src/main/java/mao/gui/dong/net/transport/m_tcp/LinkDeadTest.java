package mao.gui.dong.net.transport.m_tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/31 上午11:53
 */
public class LinkDeadTest {
    public static Logger log = Logger.getLogger(LinkDeadTest.class.getName());
    public static void main(String[] args) throws IOException {
        ArrayBlockingQueue<SocketChannel> socketChannels = new ArrayBlockingQueue<SocketChannel>(10);
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8888));
        ssc.configureBlocking(false);
        ByteBuffer buff = ByteBuffer.allocate(1024);
        while (true){
            SocketChannel sc = ssc.accept();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(sc!=null){
                log.info("收到新链接："+sc.getRemoteAddress().toString());
                sc.configureBlocking(false);
                socketChannels.add(sc);
            }
            for (SocketChannel soc : socketChannels) {
                try {
                    int read = soc.read(buff);
                    if(read==-1){
                        log.info("客户端主动断开了链接");
                        soc.close();
                        socketChannels.remove(soc);
                        continue;
                    }
                    if(read>0){
                        log.info("收到客户端："+soc.getRemoteAddress().toString()+"的消息："+new String(buff.array(),0,buff.position()));
                        buff.clear();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    log.info("链接被对方强制断开");
                    soc.close();
                    socketChannels.remove(soc);
                    continue;
                }
            }
        }
    }
}

class SockClient{
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel sc = SocketChannel.open(new InetSocketAddress(8888));
        while (true){
            sc.write(ByteBuffer.wrap(String.valueOf(System.currentTimeMillis()).getBytes()));
            Thread.sleep(2000);
        }
    }
}