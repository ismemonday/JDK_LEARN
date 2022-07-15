package mao.gui.dong.net.transport.m_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


/**
 * @author maoguidong
 */
public class MyUdpClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(6000);
        DatagramPacket datagramPacket = new DatagramPacket("hello is me udp client".getBytes(), 10, new InetSocketAddress("10.10.68.72", 6000));
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            byte[] bytes = "hello is me udp client".getBytes();
            datagramPacket.setData(bytes);
            datagramPacket.setLength(bytes.length);
            datagramSocket.send(datagramPacket);
            byte[] buf=new byte[1024];
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        }
    }
}
