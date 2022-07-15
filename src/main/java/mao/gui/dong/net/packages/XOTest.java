package mao.gui.dong.net.packages;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/29 下午3:18
 */
public class XOTest {
    public static void main(String[] args) {
        byte[] bytes=new byte[]{0x50,0x00,0x00, (byte) 0xff, (byte) 0xff,0x03,0x00,0x0C,0x00,0x0A,0x00,0x01,0x04,0x00,0x00,0x64,0x00,0x00, (byte) 0xA8,0x01,0x00,0x0A};
        System.out.println(new String(bytes));

        System.out.println(new String(new byte[]{0x50, 0x00}));
        System.out.println(new String(new byte[]{0x00, (byte) 0xff}));
    }
}
