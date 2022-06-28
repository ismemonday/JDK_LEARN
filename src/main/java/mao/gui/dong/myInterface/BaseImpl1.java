package mao.gui.dong.myInterface;

import org.springframework.stereotype.Component;

/**
 * @author maoguidong
 */
@Component
public class BaseImpl1 implements BaseInterface {
    static {
        System.out.println("BaseImpl1静态代码块触发");
    }
}
