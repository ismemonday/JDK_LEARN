package mao.gui.dong.spring.resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.EventListenerMethodProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Date;

/**
 * @author maoguidong
 */
public class ResourceApp {
    private Resource template;

    public ResourceApp(Resource template) {
        this.template = template;
    }

    public void setTemplate(Resource template) {
        this.template = template;
    }

    public ResourceApp() {
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        //resourceTest();
        resourceLoaderTest();
    }

    private static void resourceTest() {
        //UrlResource urlResource = new UrlResource("http://52.82.28.14:8001/mao.txt");
        //ClassPathResource classPathResource = new ClassPathResource("bean.xml");
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
       /* Resource resource = ctx.getResource("");
        FileSystemResource fileSystemResource = (FileSystemResource) ctx.getResource("file://");
        ClassPathResource classPathResource2 = (ClassPathResource) ctx.getResource("classpath://");
        UrlResource urlResource1 = (UrlResource) ctx.getResource("https://");
        //new ResourcePatternResolver();
        Resource[] resources = ctx.getResources("bean.xml");*/
        ClassLoader classLoader = ctx.getClassLoader();
        System.out.println(classLoader);
        ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext();
        Resource resource = cxa.getResource("");
        //ResourceLoaderAware
    }

    private static void resourceLoaderTest() throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("resource.xml");
        ResourceApp bean = ctx.getBean(ResourceApp.class);
        Resource template = bean.template;
        System.out.println(template.getURL());
        System.out.println(template.getURI());
        InputStream inputStream = template.getInputStream();
        byte[] bytes=new byte[1024];
        int read = inputStream.read(bytes);
        String s = new String(bytes, 0, read);
        System.out.println(s);
    }
}
