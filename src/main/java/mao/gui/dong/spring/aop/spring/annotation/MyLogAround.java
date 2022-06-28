package mao.gui.dong.spring.aop.spring.annotation;

import java.lang.annotation.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/23 上午11:07
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLogAround {
    String value();
}
