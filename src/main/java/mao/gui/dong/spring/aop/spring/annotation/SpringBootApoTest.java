package mao.gui.dong.spring.aop.spring.annotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author maoguidong
 */

@SpringBootTest//测试类的启动
@EnableAutoConfiguration//开启依赖通过@Autowired注入或自动注入
@ComponentScan //开启包扫描，默认扫描当前包和上路径的包，叔伯包无法扫描到
public class SpringBootApoTest {



    @Autowired
    private Student student;

    @Autowired
    private MyAopConfig aopConfig;



    @BeforeEach
    public void testBefore(){
        //System.out.println("before each");
        //given(configMock.getStudent()).willReturn(new Student(50,"mao"));
    }


    @Test
    public void test1(){
        //System.out.println(configMock.getStudent().getName());
    }



    @Test
    public void test2(){
        student.testHAA();
    }




}
