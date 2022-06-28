package mao.gui.dong.mydata;



import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author maoguidong
 */
public class MyData {
    private Student student;
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MyData myData = new MyData();
        Future<Student> student = myData.getStudent();
        System.out.println(student.isDone());
        System.out.println(student.get(6000, TimeUnit.MILLISECONDS));
    }

    private AbstractFuture<Student> getStudent() {
        student=new Student();
        new Thread(()->{
            try {
                Thread.sleep(5000);
                 student.setAge(10);
                 student.setCode(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return student;
    }

     class Student extends AbstractFuture<Student> {
        private int age;
        private int code;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }


         @Override
         public String toString() {
             return "Student{" +
                     "age=" + age +
                     ", code=" + code +
                     '}';
         }

     }

}
