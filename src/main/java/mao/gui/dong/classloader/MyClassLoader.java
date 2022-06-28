package mao.gui.dong.classloader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;


/**自定义类加载器，重写findClass方法用defineClass()
 * ClassLoader中有三个核心方法：
 * 1.loadClass()--类加载入口，次方法实现了类加载的双亲委托机制
 * 2.findClass()--类加载实现的入口，通过io加载.class文件
 * 3.defineClass()--类加载解析，通过输入.class文件的byte[]形式获取真正的类信息。
 * @author maoguidong
 */
public class MyClassLoader extends ClassLoader implements Serializable {
    static {
        System.out.println("i am MyClassloader");
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //1.io加载.class文件，可以通过本地计算机中加载也可以通过网络中加载
        try {
            URL url = new URL("http://localhsot:8080/hello.class");
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            int len=0;
            while ((len=inputStream.read(buf))!=-1){
                baos.write(buf, 0, len);
            }
            inputStream.close();
            baos.close();
            //2.通过defineClass()去解析加载真正的类信息
            return defineClass("",baos.toByteArray(),0,baos.size());
        }catch (Exception e){
            return null;
        }
    }


    public static void hello(){
        System.out.println("say hello myClassLoader");
    }
}
