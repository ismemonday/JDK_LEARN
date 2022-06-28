package mao.gui.dong.spring.aop.spring.annotation;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/23 上午11:24
 */
@Configuration
@SpringBootConfiguration
public class Config {
    @Bean
    public Student getStudent(){
        Student student = new Student();
        student.setAge(11);
        student.setName("li");
        return student;
    }
}
