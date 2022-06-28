package mao.gui.dong.spring.aop.spring.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/23 上午11:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int age;
    private String name;

    @MyLogAround("标记")
    public void doSome(){
        System.out.println("做了一些什么东西");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @MyLogAround("maomao")
    public void testHAA(){
        System.out.println("GOOD NAME");
    }
}
