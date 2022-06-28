package mao.gui.path;

import java.io.File;
import java.net.URI;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class PythTest {
    public static void main(String[] args) {
        URI test = new File("test").toURI();
        System.out.println(test.getPath());

    }
}
