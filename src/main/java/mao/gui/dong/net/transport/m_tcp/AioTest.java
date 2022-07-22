package mao.gui.dong.net.transport.m_tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/21 下午2:11
 */
public class AioTest {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        AsynchronousServerSocketChannel assc = AsynchronousServerSocketChannel.open();
        assc.bind(new InetSocketAddress(8888));
        ConcurrentLinkedQueue<AsynchronousSocketChannel> socketChannels=new ConcurrentLinkedQueue<>();
        AbstractSelector selector = SelectorProvider.provider().openSelector();
        CompletionHandler<AsynchronousSocketChannel, Object> compiled = new CompletionHandler<>() {
            @Override
            public void completed(AsynchronousSocketChannel sc, Object attachment) {
                assc.accept(sc, this);
                try {
                    System.out.println(Thread.currentThread().getName()+":服务接受了一个新的远程链接:"+sc.getRemoteAddress().toString());
                    sc.write(ByteBuffer.wrap(":SERVER RECEIVE CONNECT\n".getBytes()));
                    socketChannels.add(sc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println(Thread.currentThread().getName()+":failed");
                exc.printStackTrace();
            }
        };
        assc.accept(null, compiled);
        ByteBuffer buff = ByteBuffer.allocate(256);
        while (true){
            AsynchronousSocketChannel asc = socketChannels.peek();
            if(asc!=null){
                Future<Integer> read = asc.read(buff);
                if (read.isDone()) {
                    Integer result = read.get();
                    if(result>0){
                        System.out.println(new String(buff.array()));
                    }
                }else {
                    read.cancel(true);
                }
                buff.clear();
            }
            new Thread().start();
        }
    }
}
