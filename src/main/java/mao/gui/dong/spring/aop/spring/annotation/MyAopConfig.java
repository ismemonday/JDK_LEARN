package mao.gui.dong.spring.aop.spring.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/3/23 下午4:03
 */
@Aspect
@Component
public class MyAopConfig {


    @Around("@annotation(mao.gui.dong.spring.aop.spring.annotation.MyLogAround)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = point.proceed();
        long end = System.currentTimeMillis();
        System.out.println("方法：" + point.getSignature().getName() + " 执行耗时：" + (end - start) + "ms");
        return proceed;
    }


}
