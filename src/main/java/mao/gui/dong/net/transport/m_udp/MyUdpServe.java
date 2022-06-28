package mao.gui.dong.net.transport.m_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author maoguidong
 */
public class MyUdpServe {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        byte[] buf=new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf,1024);
        while (true){
            datagramSocket.receive(datagramPacket);
            System.out.println(datagramPacket.getLength());
            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
            byte[] bytes = "hello is me udp server".getBytes();
            datagramPacket.setData(bytes);
            datagramPacket.setLength(bytes.length);
            datagramSocket.send(datagramPacket);
            Thread.sleep(1000);
        }
    }
}
