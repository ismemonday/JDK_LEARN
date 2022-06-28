package mao.gui.dong.serializeable.alibabaJson;

import java.io.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/2/22 下午6:17
 */
public class SeriazliableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //seriazlibeTest();
        resolveSerializable();
    }

    private static void resolveSerializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/home/maoguidong/tem/dog"));
        Dog dog = (Dog) objectInputStream.readObject();
        System.out.println(dog.toString());
        objectInputStream.close();
    }

    private static void seriazlibeTest() throws IOException {
        Dog dog = new Dog();
        dog.setAge(15);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/home/maoguidong/tem/dog2"));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();
    }
}
class Dog implements Serializable{
    //private static final long serialVersionUID = 1995L;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}
