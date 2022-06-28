package mao.gui.dong.jni;

import mao.gui.dong.entitys.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author maoguidong
 * 1.生成.h头文件/home/maoguidong/.jdks/openjdk-14.0.2/bin/javac MyJniTest.java -h .
 * 2.替换头文件中java自带的jni.h的位置#include "/home/maoguidong/.jdks/openjdk-14.0.2/include/jni.h"
 * 3.编辑.c和.h文件为.so动态链接文件gcc -fPIC -shared JniTestHello.cpp -o JniHello.so
 * 4.java中直接引入.so文件运行代码,文件需要绝对路径绝对路径
 */
public class MyJniTest {
    public static native void hello();
    static{
        //System.loadLibrary("/home/maoguidong/ideaprojects/JDK_Learn/src/main/java/mao/gui/dong/jni/JniHello.so");
        //System.load("src/main/java/mao/gui/dong/jni/JniHello.so");

    }
    public static void main(String[] args){
        //hello();
        File file = new File("src/main/java/mao/gui/dong/jni/JniHello.so");
        System.out.println(file.isAbsolute());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
        File file1 = new File(".");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        String hello = System.getProperty("hello");
        List<Student> students = new ArrayList<Student>();
       //Collections.sort(students);
    }


}
