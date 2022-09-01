package mao.gui.dong.spring.aop.aspectj;

/**
 * 代理原理是在编译时处理,静态代理,需要使用ajc编译器
 */
public class AspectTest {
    public static void main(String[] args) {
        new UserDaoImpl().addUser();
    }
}
