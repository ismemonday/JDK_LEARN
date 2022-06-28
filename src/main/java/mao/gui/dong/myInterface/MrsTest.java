package mao.gui.dong.myInterface;

import java.nio.ByteBuffer;
import java.util.concurrent.locks.LockSupport;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/29 下午9:18
 */
public class MrsTest {
    private int age;
    private ByteBuffer bodyBuff;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ByteBuffer getBodyBuff() {
        return bodyBuff;
    }

    public void setBodyBuff(ByteBuffer bodyBuff) {
        this.bodyBuff = bodyBuff;
    }

    public MrsTest(int age, ByteBuffer bodyBuff) {
        this.age = age;
        this.bodyBuff = bodyBuff;
    }

}

class MrsBeanTest{
    public static void main(String[] args) {
        MrsTest mrsTest = new MrsTest(18,ByteBuffer.allocate(10));
        int age = mrsTest.getAge();
        ByteBuffer bodyBuff = mrsTest.getBodyBuff();
        age=20;
        bodyBuff=ByteBuffer.allocate(20);
        mrsTest.setBodyBuff(bodyBuff);
        bodyBuff.put(new byte[]{2,5,6});
        System.out.println(mrsTest);
        LockSupport.park();
    }
}
