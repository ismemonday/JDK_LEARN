package mao.gui.dong.rmi;

import java.io.Serializable;
import java.rmi.Remote;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/12 下午7:47
 */
public class UserService implements Remote, Serializable {
    private String name;
    private int age;

    public UserService() {
        this.name="liming";
        this.age=18;
    }

    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
