package mao.gui.dong.net.application;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/13 下午4:24
 */
public class NettySource {
    private static final Logger log=Logger.getLogger(NettySource.class.getName());

    public static void main(String[] args) throws Exception {
        ServerBootstrap bootStrap = new ServerBootstrap();
        bootStrap.
                group(new NioEventLoopGroup(2), new NioEventLoopGroup()).
                channel(NioServerSocketChannel.class).
                childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new MyChannelHandler());
                        ch.pipeline().addLast(new MyChannelHandler2());
                    }
                });
        ChannelFuture f1 = bootStrap.bind(8080);


    }
}

class PassTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        AbstractSelector selector = SelectorProvider.provider().openSelector();
        ssc.configureBlocking(false);
        SelectionKey register = ssc.register(selector, 16);
        SelectionKey register2 = ssc.register(selector, 0);
        new Thread(() -> {
            while (true) {
                try {
                    int select = selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        iterator.remove();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(100);
        //register.interestOps(16);
    }

}

class SelectorT {
    private static final Logger log=Logger.getLogger(SelectorT.class.getName());
    public static void main(String[] args) throws IOException, InterruptedException {
        AbstractSelector selector = SelectorProvider.provider().openSelector();
        java.nio.channels.SocketChannel sc = SelectorProvider.provider().openSocketChannel();
        sc.configureBlocking(false);
        SelectionKey key0 = sc.register(selector, 0, "");
        new Thread(()->{
            while (true) {
                try {
                    log.info("select前");
                    selector.select();
                    log.info("select后");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    selectionKeys.remove(next);
                    Selector selector1 = next.selector();
                    if (next.isConnectable()) {
                        SelectableChannel channel = next.channel();
                        System.out.println(channel.isRegistered());
                    }
                    if (next.isReadable()) {
                        java.nio.channels.SocketChannel channel = (java.nio.channels.SocketChannel) next.channel();
                    }
                }
            }
        }).start();
        Thread.sleep(5000);
        log.info("开始重新设置key");
        key0.interestOps(4);
    }
}
