package mao.gui.dong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/1/12 下午5:34
 */
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {
    String role() default "CEO";
}
