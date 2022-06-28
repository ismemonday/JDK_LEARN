package mao.gui.dong.net.application.netty.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/13 下午5:48
 */
public class InMsgHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg) throws Exception {
        System.out.println("读到数据" + msg);
        ctx.fireChannelRead(msg);
    }
}
