package mao.gui.dong.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk的动态代理,原理是运行时修改,利用反射机制
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/12 上午10:13
 */
public class JdkAopTest {
    public static void main(String[] args) {
        //原对象
        UserDao userDao = new UserDaoImpl();

        //创建一个代理类来实现
        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置处理");
                Object invoke = method.invoke(userDao, args);
                return invoke;
            }
        });

        //代理对象调用
        proxy.deleteUser();

    }


}

class Reflect{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        UserDao dao=createProxy(userDaoImpl,UserDao.class);
        dao.addUser();
    }

    private static UserDao createProxy(UserDaoImpl userDaoImpl, Class<UserDao> userDaoClass) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method[] methods = userDaoClass.getMethods();
        for (Method method : methods) {
            method.invoke(userDaoImpl,null );
        }
        return userDaoClass.getConstructor(null).newInstance();
    }
}

class ReflectMeth{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<UserDaoImpl> userDaoClass1 = UserDaoImpl.class;
        UserDaoImpl userDao = new UserDaoImpl();
        InvocationHandler h=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置处理");
                Object invoke = method.invoke(userDao, args);
                return invoke;
            }
        };
        UserDaoImpl userDao1 = userDaoClass1.getConstructor(null).newInstance(new Object[]{h});
        userDao1.addUser();
    }
}
