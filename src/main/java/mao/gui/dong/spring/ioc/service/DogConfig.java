package mao.gui.dong.spring.ioc.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/1/27 下午1:50
 */
@Configuration
public class DogConfig {
    @Bean
    public Dog createDog(){
        Dog dog = new Dog();
        dog.setName("hashiqi");
        return dog;
    }
}
