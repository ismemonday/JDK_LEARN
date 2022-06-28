package mao.gui.dong.net.application.m_websocket;

import java.nio.ByteBuffer;

/**
 * @author maoguidong
 */
public class MyWebSocketTest {
    public static void main(String[] args) {
        MyWebSocket myWebSocket = new MyWebSocket();
        myWebSocket.sendPing(ByteBuffer.allocate(13));

    }
}
