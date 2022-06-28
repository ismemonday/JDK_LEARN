package mao.gui.dong.net.application.netty.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/13 下午5:48
 */
public class OutMsgHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
      ctx.write("hello wor5ld");
    }
}
