package mao.gui.dong.net.packages;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午2:09
 */
public class PackTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String[] strings=new String[]{"50","00","00","ff","ff","03","00","0C","00","0A","00","01","04","00","00","64","00","00","A8","01","00","0A"};
        byte[] arr=new byte[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i]=(byte) Integer.parseInt(strings[i],16);
        }
        System.out.println(arr);
        System.out.println("---------");
        for (int i : arr) {
            System.out.print((char) i);
        }
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket(arr, 0,arr.length, new InetSocketAddress("10.10.68.72", 6000));
        datagramSocket.send(datagramPacket);
        datagramSocket.send(datagramPacket);
        datagramSocket.send(datagramPacket);
        while (true){
            LockSupport.park();

        }

    }
}
