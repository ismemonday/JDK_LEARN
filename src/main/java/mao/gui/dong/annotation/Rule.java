package mao.gui.dong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/26 下午3:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Rule {

    String name() default "规则名";

    String description() default "规则描述";

}
