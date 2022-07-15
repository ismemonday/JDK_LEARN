package mao.gui.dong.net.application;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/13 下午4:42
 */
public class MyChannelHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
        ByteBuf buf= (ByteBuf) msg;
        System.out.println("收到客户端:"+ctx.channel().remoteAddress()+"的消息:" + buf.toString(Charset.defaultCharset()));
        //ctx.fireChannelRead(msg);
        ctx.writeAndFlush(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("good");
    }
}
