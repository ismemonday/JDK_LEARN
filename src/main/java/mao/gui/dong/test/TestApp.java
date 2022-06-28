package mao.gui.dong.test;


import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class TestApp {


    public static void main(String[] args) throws IOException, InterruptedException {
        User user = new User();
        user.setAge("hello");
        User user1=user;
        user1.setAge("good");
    }
}
