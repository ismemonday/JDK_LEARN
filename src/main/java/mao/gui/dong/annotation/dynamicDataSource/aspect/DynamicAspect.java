package mao.gui.dong.annotation.dynamicDataSource.aspect;

import mao.gui.dong.annotation.dynamicDataSource.anno.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.annotation.Annotation;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/11 下午3:32
 */
@Aspect
public class DynamicAspect {


    @Pointcut("@target(mao.gui.dong.annotation.dynamicDataSource.anno.DynamicDataSource)")
    public void pointCut1(){

    }

    @Before("pointCut1()")
    public void doSome(JoinPoint joinPoint){
        System.out.println(joinPoint.toString());
        Annotation annotation = joinPoint.getSignature().getDeclaringType().getAnnotation(DynamicDataSource.class);
        if(annotation!=null){
            DynamicDataSource anno= (DynamicDataSource) annotation;
            System.out.println("当前的值是:"+anno.value());
        }
        System.out.println("11");
    }

}
