package mao.gui.dong.net.transport.m_tcp;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * @author maoguidong
 */
public class MyTcpService {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 6666));
        /**
         * 1.accept()是一个同步阻塞的方法，如何想要多客户端同时操作需要用到多线程
         * 2.read()也是一个同步阻塞的方法
         * 3.因此这样写只能是：客户端链接-发送消息-断开 ..... 客户端链接-发送消息-断开
         */
        while (true){
            Socket accept = serverSocket.accept();
            System.out.println("有一个客户端链接成功:" + accept.getRemoteSocketAddress());
            InputStream inputStream = accept.getInputStream();
            //假设只需读一次
            //应为内存中的buffer默认为8k
            byte[] bytes=new byte[1024*8];
            int read = inputStream.read(bytes);
            if(read!=-1){
                String request = new String(bytes, 0, read);
                System.out.println("接受客户端的消息是："+request);
                OutputStream outputStream = accept.getOutputStream();
                Properties properties = new Properties();
                String resp="HTTP/1.1 200 OK\n" +
                        "Date: Fri, 22 May 2009 06:07:21 GMT\n" +
                        "Content-Type: text/plain; charset=UTF-8\n" +
                        "\n" +"我已经收到你的数据啦"+request;
                outputStream.write(resp.getBytes());
                outputStream.flush();
                outputStream.close();
                String[] split = request.split("\n");
                for (String s : split) {
                    if(s.startsWith("name")){
                        System.out.println(s);
                        String s1 = s.split(":")[1];
                        System.out.println(s1.length());
                        System.out.println(s1.trim().length());
                    }else if(s.startsWith("age")){
                        System.out.println(s);
                        String s1 = s.split(":")[1];
                        System.out.println(s1.length());
                        System.out.println(s1.trim().length());
                    }
                }
            }else {
                System.out.println("链接失败");
                inputStream.close();
                accept.close();
            }


        }

    }
}
