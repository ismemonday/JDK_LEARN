package mao.gui.dong.net.transport.m_tcp.aio;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/21 下午4:59
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {


    @Override
    public void completed(Integer result, ByteBuffer byteBuffer) {
        System.out.println(new String(byteBuffer.array()));
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
