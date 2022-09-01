package mao.gui.dong.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/18 下午3:04
 */
public class ReflectTest {
    public static void main(String[] args) {
        DogInterface dogInterface = new DogInterface() {
            @Override
            public int yield(int age, int size) {
                System.out.println("主方法执行");
                return 18;
            }
        };

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("1111");
                return method.invoke(dogInterface, args);
            }
        };
        DogInterface f = (DogInterface) Proxy.newProxyInstance(DogInterface.class.getClassLoader(),
                                                          new Class<?>[] { DogInterface.class },
                                        invocationHandler);

        int yield = f.yield(111, 666);



    }
}
