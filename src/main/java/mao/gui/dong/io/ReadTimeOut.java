package mao.gui.dong.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/12 上午10:02
 */
public class ReadTimeOut {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] data=new byte[256];
        inputStream.read(data);
        for (;;){
            LockSupport.park();
        }


    }
}
