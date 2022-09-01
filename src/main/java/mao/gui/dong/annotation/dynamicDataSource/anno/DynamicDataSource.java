package mao.gui.dong.annotation.dynamicDataSource.anno;
import java.lang.annotation.*;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/11 下午3:20
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicDataSource {
    String value() default "default";
}
