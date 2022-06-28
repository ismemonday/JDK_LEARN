package mao.gui.dong.annotation;

import java.lang.annotation.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/1/12 下午5:36
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Persons {
    Person[] value();
}
