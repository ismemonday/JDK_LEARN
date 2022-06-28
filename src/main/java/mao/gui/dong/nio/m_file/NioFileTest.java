package mao.gui.dong.nio.m_file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

/**
 * @author maoguidong
 * 感觉跟普通的io没什么区别
 * nio的优势主要在于网路中的非阻塞（传输层的编程）
 */
public class NioFileTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //1.channelPath.of("")
        Path path = Path.of(new URI("file:/home/maoguidong/ideaprojects/JDK_Learn/mao.txt"));
        FileChannel file = FileChannel.open(path);
        //2.buffer
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        file.read(allocate);
        System.out.println(new String(allocate.array()));
        ByteBuffer allocate1 = ByteBuffer.allocate(10);



    }
}
