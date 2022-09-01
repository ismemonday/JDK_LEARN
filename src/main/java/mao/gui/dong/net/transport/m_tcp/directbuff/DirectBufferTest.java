package mao.gui.dong.net.transport.m_tcp.directbuff;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.concurrent.locks.LockSupport;

/**
 *DirectByteBuff提升大概10%性能
 * 注意DirectByteBuff需要手动回收
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/29 上午10:13
 */
public class DirectBufferTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        long start = System.currentTimeMillis();
        //ByteBuffer allocate = ByteBuffer.allocate(1);//41800ms
        ByteBuffer allocate=ByteBuffer.allocateDirect(1024*1024*1024);//37620ms
        int countNum=0;
        FileChannel fi = FileChannel.open(Path.of("/home/maoguidong/下载/20210112_nav.map_export"));
        while (fi.read(allocate)>0){
            allocate.flip();
            countNum++;
            allocate.get();
            allocate.clear();
        }
        //手动回收allocate内存
        clean(allocate);
        LockSupport.park();
        long end=System.currentTimeMillis();
        System.out.println("长度:"+countNum+",耗时:"+(end-start));
    }

    private static void clean(ByteBuffer allocate){
        if (allocate.isDirect()) {
            //是直接内存
            try {
                Field cleaner = allocate.getClass().getDeclaredField("cleaner");
                cleaner.setAccessible(true);
                Method method = Class.forName("jdk.internal.ref.Cleaner").getMethod("clean", null);
                //method.setAccessible(true);
                method.invoke(cleaner.get(allocate),null);
                System.out.println("direct内存释放成功");
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
}
