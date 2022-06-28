package mao.gui.dong.myInterface;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author maoguidong
 * 需求：获取实现BaseInterface的所有实现类
 */
public class TestInterfaceApp {
    private final BaseInterface baseInterface;

    public TestInterfaceApp(BaseInterface baseInterface) {
        this.baseInterface = baseInterface;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        /*ApplicationContext applicationContext = new AnnotationConfigApplicationContext("mao.gui.dong.myInterface");
        InterfaceService bean = applicationContext.getBean(InterfaceService.class);
        List<BaseInterface> baseInterfaces = bean.getBaseInterfaces();
        System.out.println(baseInterfaces.size());*/
        testMethod3();
    }



    /**
     * 方式一，通过文件获取接口文件.class文件的位置，然后遍历所有文件，找到当前包下面的所有类
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void byFileClass() throws IllegalAccessException, InstantiationException {
       // 1） 获取当前线程的ClassLoader
        ClassLoader classLoader = BaseInterface.class.getClassLoader();
        // 2） 通过ClassLoader获取当前工作目录，对目录下的文件进行遍历扫描。
        URL resource = classLoader.getResource("");
        Package[] definedPackages = classLoader.getDefinedPackages();
        String name = definedPackages[0].getName();
        // 3） 过滤出以.class为后缀的类文件，并加载类到list中
        File file = new File(resource.getFile(), name.replace(".", File.separator));
        // 4） 对list中所有类进行校验，判断是否为指定接口的实现类，并排除自身。
        ArrayList<File> files=new ArrayList<>();
        getArrayFile(files,file,BaseInterface.class);
        // 5） 返回所有符合条件的类。
        ArrayList<Class<?>> clazzs=new ArrayList<>();
        for (File clazzFile : files) {
            //1.将文件字符串名转换为包名
            String packageName=transformPackageName(clazzFile);
            //2.加载类文件
            Class c=loadClass(packageName);
            //3.类文件过滤
            if(!c.isInterface()&&c.newInstance() instanceof BaseInterface){
                clazzs.add(c);
            }

        }
        for (Class<?> clazz : clazzs) {
            System.out.println(clazz.getName());
        }

    }

    /**
     * 方式二：通过spring的ApplicationContext获取
     */
    private static void bySpringApplicationContext() {
        Map<String, BaseInterface> beansOfType = new ClassPathXmlApplicationContext().getBeansOfType(BaseInterface.class);
    }


    private static void testMethod3(){
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            @Override
            public Void run() {
                ServiceLoader<BaseInterface> load = ServiceLoader.load(BaseInterface.class);
                Iterator<BaseInterface> iterator = load.iterator();
                while (iterator.hasNext()){
                    iterator.next();
                }
                return null;
            }
        });
    }



    /**
     * 1.java默认使用包名+类名的方式加载类
     * 2.如何想通过文件位置的形式加载类，需要重写findClass（）方法，并调用defineClass（）
     * @param packageName
     * @return
     */
    private static Class loadClass(String packageName) {
        try {
            //1.forName加载--会执行初始化（执行静态代码块）
            //return Class.forName(packageName,false,ClassLoader.getSystemClassLoader());
            //2.ClassLoader加载（只会加载到JVM中不会执行静态代码块）
            return new ClassLoader(){}.loadClass(packageName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String transformPackageName(File clazzFile) {
        String packageName = BaseInterface.class.getClassLoader().getDefinedPackages()[0].getName();
        packageName=packageName+"."+clazzFile.getName();
        packageName=packageName.replace( ClassUtils.CLASS_FILE_SUFFIX, "");
        return packageName;
    }

    private static void getArrayFile(ArrayList<File> arrayList,File file, Class<BaseInterface> baseInterfaceClass) {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File file1 : files) {
                getArrayFile(arrayList,file1, BaseInterface.class);
            }
        }else if(file.isFile()){
            if(file.getName().endsWith( ClassUtils.CLASS_FILE_SUFFIX)){
                arrayList.add(file);
            }
        }
    }
}
