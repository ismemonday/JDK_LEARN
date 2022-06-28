package mao.gui.dong.classloader;

import java.lang.reflect.InvocationTargetException;

/**
 * 类加载的核心ClassLoader,有三个核心类加载器
 * 1.BootClassLoader:父类加载器
 * 2.PlatformClassLoader:扩展类加载器
 * 3.AppClassLoader;系统默认类加载器
 * 自定义类加载器：
 *  1.自定义继承ClassLoader重写findClass()方法
 *  2.使用URLClassLoader()
 * @author maoguidong
 */
public class LoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       //1.系统类默认加载器AppClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
       //2.自定义类加载
         //2.1继承ClassLoader
           /* MyClassLoader myClassLoader = new MyClassLoader();
            Class<?> aClass = myClassLoader.loadClass("com.hello");
            Object o = aClass.getDeclaredConstructor(null).newInstance("");
          //2.2通过URLClassLoader,可以指定父加载器不指定就使用默认的
            URLClassLoader urlClassLoader = new URLClassLoader(null, myClassLoader);*/
    }
}
