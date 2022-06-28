package mao.gui.dong.exception;

import org.junit.platform.commons.util.ExceptionUtils;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/25 上午9:52
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("223456i");
        }catch (Exception e){
            System.out.println(e);
            System.out.println(e.toString());
            System.out.println(e.getStackTrace().toString());
            System.out.println(ExceptionUtils.readStackTrace(e));
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(new Stu(15,"li"));
    }



}
class Stu{
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stu(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}