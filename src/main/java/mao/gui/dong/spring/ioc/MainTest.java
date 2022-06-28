package mao.gui.dong.spring.ioc;


import mao.gui.dong.spring.ioc.service.BaseServiceImpl;
import mao.gui.dong.spring.ioc.service.Dog;
import mao.gui.dong.spring.ioc.service.DogConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        //xmlTest();
        annotationTest();
        //webAnnotationTest();
        //interfaceTest();

    }

    private static void webAnnotationTest() {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.scan("mao.gui.dong.spring.ioc.dao","mao.gui.dong.spring.ioc.service");

    }

    private static void annotationTest() {
        AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext("mao.gui.dong.spring.ioc.dao","mao.gui.dong.spring.ioc.service");
        DogConfig bean = annotation.getBean(DogConfig.class);
        Dog dog = annotation.getBean(Dog.class);
        System.out.println(dog.getName());
    }

    private static void xmlTest() throws IOException {
        //System.out.println(new BaseServiceImpl(new dogDB()).getName());
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

       // ApplicationContext context = new FileSystemXmlApplicationContext(MainTest.class.getResource("")+"./beas/beans.xml");
        BaseServiceImpl baseService= (BaseServiceImpl) context.getBean("baseService");
        System.out.println(baseService.getName());
        Resource resource = context.getResource("classpath:template.txt");
        /*System.out.println(resource.exists());
        System.out.println(resource.getFilename());
        System.out.println(resource.getURI());
        System.out.println(resource.getURL());
        System.out.println(baseService.getTemplate());*/
        File template = baseService.getTemplate();
        FileInputStream fileInputStream = new FileInputStream(template);
        byte[] bytes = new byte[1024];
        int read = fileInputStream.read(bytes);
        byte[] bytes1 = new byte[read];
        BeanUtils.copyProperties(bytes, bytes1);
        System.out.println(new String(bytes1));
        System.out.println(new String(bytes));
    }

    /**
     * 初始化实现了BaseService的所有实现类
     */
    static void interfaceTest(){
        Class<?>[] interfaces = BaseServiceImpl.class.getInterfaces();
        Class<?> anInterface = interfaces[0];


        try {
            Object o = anInterface.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
