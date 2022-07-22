package mao.gui.dong.net.transport.m_tcp.aio;

import lombok.SneakyThrows;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/21 下午4:59
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    @SneakyThrows
    @Override
    public void completed(AsynchronousSocketChannel result, Object attachment) {
        System.out.println("receive result" + result.getRemoteAddress().toString());
            ByteBuffer allocate = ByteBuffer.allocate(256);
            result.read(allocate, allocate, new ReadHandler());
    }

    @Override
    public void failed(Throwable exc, Object attachment) {

    }
}
