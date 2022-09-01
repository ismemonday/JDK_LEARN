package mao.gui.dong.spring.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {
    public static void main(String[] args) {
        Dog dog1 = new Dog();

        //方法拦截
        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("对目标进行增强");
                return proxy.invoke(dog1, args);
            }
        };

        Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Dog.class);
            enhancer.setCallback(interceptor);
            Dog dog = (Dog) enhancer.create();
            dog.call("hahaha");
    }
}
