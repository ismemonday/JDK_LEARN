package mao.gui.dong.net.application.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import mao.gui.dong.net.application.netty.handlers.InMsgHandler;
import mao.gui.dong.net.application.netty.handlers.OutMsgHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.spi.SelectorProvider;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/13 下午5:47
 */
public class NettyApp {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);

        NioEventLoopGroup workGroup = new NioEventLoopGroup(1);
//        bootstrap.channelFactory(new ChannelFactory() {
//            @Override
//            public Channel newChannel() {
//                return new NioServerSocketChannel();
//            }
//        });
        Class<NioServerSocketChannel> clazz = NioServerSocketChannel.class;
        Constructor<NioServerSocketChannel> constructor = clazz.getConstructor();
        NioServerSocketChannel nioServerSocketChannel = constructor.newInstance();
        NioServerSocketChannel nioServerSocketChannel1 = new NioServerSocketChannel();
        SelectorProvider provider = SelectorProvider.provider();



        bootstrap.channelFactory(new ReflectiveChannelFactory<>(NioServerSocketChannel.class));
        bootstrap.group(bossGroup,workGroup).
                //channel(NioServerSocketChannel.class).
                childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new InMsgHandler());
                        ch.pipeline().addLast(new OutMsgHandler());
                    }
                });
        bootstrap.bind(8080);
    }
}
