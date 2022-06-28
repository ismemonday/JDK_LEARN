package mao.gui.dong.spring.aop.spring.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class AopApiTest {
    public static void main(String[] args){
       String path=AopApiTest.class.getResource("").getPath();
        System.out.println(path);
        ApplicationContext context = new FileSystemXmlApplicationContext( "/apibean.xml");
        SleepServiceImpl sleep = context.getBean("sleep", SleepServiceImpl.class);
        sleep.sleep();
    }
}
