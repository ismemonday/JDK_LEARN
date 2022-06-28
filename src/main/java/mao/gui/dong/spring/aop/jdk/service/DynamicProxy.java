package mao.gui.dong.spring.aop.jdk.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author maoguidong
 */
public class DynamicProxy implements InvocationHandler {
    private Object proxyInstance;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object in = method.invoke(proxyInstance, args);
        return in;
    }

    public Object newProxyInstance(Object proxyInstance){
        this.proxyInstance=proxyInstance;
        return Proxy.newProxyInstance(proxyInstance.getClass().getClassLoader(),proxyInstance.getClass().getInterfaces(),this);
    }
}
