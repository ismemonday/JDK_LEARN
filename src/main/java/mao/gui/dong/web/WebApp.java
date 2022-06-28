package mao.gui.dong.web;


import mao.gui.dong.entitys.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 * @author maoguidong
 */

@ComponentScan("mao.gui.dong.spring.ioc.dao")
public class WebApp {
    public static void main(String[] args) {
//        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//        webApplicationContext.scan("mao.gui.dong.web");
//        MyWebApplicationInitializer bean = webApplicationContext.getBean(MyWebApplicationInitializer.class);
//        System.out.println(bean);
      /*  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(WebApp.class);
        context.refresh();
        //context.scan("mao.gui.dong.spring.ioc.dao");
        Object bean1 = context.getBean(WebApp.class);
        BaseDB bean = context.getBean("cat",BaseDB.class);
        System.out.println(bean);
        System.out.println(bean1);*/
        //System.out.println("HeLlo".toUpperCase().toLowerCase());
        Student student = new Student();

        System.out.println(student.getIndex());
        System.out.println(student.getAge());
    }

    @GetMapping("/hello")
    public String hello(Model model) throws IOException {
        model.addAttribute("message","hello world");
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(InetSocketAddress.createUnresolved("127.0.0.1",5001));
        return "index";

    }
}
