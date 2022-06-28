package mao.gui.dong.net.transport.m_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/28 上午9:30
 */
public class BIOSocketStateTest {

}

class Server{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("已经开始监听6666");
        Socket accept = serverSocket.accept();
        System.out.println("接受到客户端的链接");
        byte[] bytes=new byte[1024];
        accept.getInputStream().read(bytes);
        System.out.println("接受到客户端的消息为："+new String(bytes));
    }
}

class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 6666);
        System.out.println(socket.isConnected());
        socket.getOutputStream().write(new String("hello server").getBytes());
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
    }
}