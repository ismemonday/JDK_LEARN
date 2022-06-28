package mao.gui.dong.design23.singleton;


import mao.gui.dong.entitys.Student;

import java.util.HashSet;

/**
 * @author maoguidong
 */
public class SingetonStyle {


   private  static Student student;

   private final static Student studentHungry=new Student();

    /**
     * 添加volatile的作用是实现线程可见性
     */
   private static volatile Student fullStudent;




    /**
     * 饿汉模式
     * @return
     */
   public static Student HungerSingleton(){
       return studentHungry;
   }

    /**
     * 不安全的懒汉模式
     * @return
     */
   public static Student unSafeLazySingleton(){
       if(student==null){
           student=new Student();
       }
       return student;
   }

    /**
     * 饱汉或者懒汉模式线程安全
     * @return
     */
    public synchronized static Student FullSingleton(){
        if(fullStudent==null){
            fullStudent=new Student();
        }
        return fullStudent;
    }

    /**
     * 双重校验锁
     * @return
     */
    public static Student doubleCheckStudent(){
        if(student==null){
            synchronized (SingetonStyle.class){
                if(student==null){
                    student=new Student();
                }
            }
        }
        return student;
    }

    public static void main(String[] args) throws InterruptedException {
        HashSet<Student> students = new HashSet<>();
        long start=System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            new Thread(()->{
                students.add(FullSingleton());
            }).start();
        }

        long end = System.currentTimeMillis();
        System.out.println(students.size());
        System.out.println("用时:"+(end-start)+"毫秒");


    }
}
