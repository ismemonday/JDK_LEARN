package mao.gui.dong.net.application;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/13 下午4:24
 */
public class NettySource {
    public static void main(String[] args) throws Exception {
        ServerBootstrap bootStrap = new ServerBootstrap();
        bootStrap.
                group(new NioEventLoopGroup(2),new NioEventLoopGroup()).
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

class PassTest{
    public static void main(String[] args) {
        new Thread().start();
    }
}
