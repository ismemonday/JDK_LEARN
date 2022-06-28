package mao.gui.dong.net.application;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.Charset;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/1 下午2:45
 */
public class NettyTest {
    public static void main(String[] args) throws Exception {
        new NettyTest().server();
    }

    public void server() throws Exception {
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
                   b.group(group,group)
                    .option(ChannelOption.SO_REUSEADDR,true)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                        }
                    });
            ChannelFuture f = b.bind(6666).sync();
            b.bind(8888).sync();
            ChannelFuture channelFuture = f.channel().closeFuture();
            channelFuture.sync();
        } finally {
            group.shutdownGracefully().sync();
        }
        System.out.println("启动完了");
    }
}
