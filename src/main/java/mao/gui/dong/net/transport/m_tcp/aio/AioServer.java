package mao.gui.dong.net.transport.m_tcp.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/21 下午5:00
 */
public class AioServer {
    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();
        assc.bind(new InetSocketAddress(8888));
        assc.accept(null, new AcceptHandler());
        LockSupport.park();
    }
}
