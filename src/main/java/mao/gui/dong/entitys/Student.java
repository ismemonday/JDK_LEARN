package mao.gui.dong.entitys;

/**
 * @author maoguidong
 */
public class Student {
    private String name;
    private  int age;
    private char sex;
    private float height;
    private Integer index;

    public Student(String name, int age, char sex, float height) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public void setIndex(Integer a) {
        this.index=a;
    }

    public Integer getIndex() {
        return index;
    }
}
