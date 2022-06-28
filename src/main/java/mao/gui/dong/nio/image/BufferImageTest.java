package mao.gui.dong.nio.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/2/23 下午2:25
 */
public class BufferImageTest {
    public static void main(String[] args) throws IOException {
            BufferedImage image = new BufferedImage(20,20,BufferedImage.TYPE_INT_RGB);
            Graphics gp = image.getGraphics();
            gp.setColor(Color.green);
            gp.fillRect(0, 0, 20, 20);
            gp.setColor(Color.red);
            gp.drawLine(3,3,17,17);
            ImageIO.write(image, "png", new FileOutputStream("/home/maoguidong/tem/test.png"));
    }
}
