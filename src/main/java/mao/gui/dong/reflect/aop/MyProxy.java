package mao.gui.dong.reflect.aop;

import mao.gui.dong.reflect.DogInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/8/18 下午3:32
 */
public class MyProxy {
    private MyInvocationHandler invocationHandler;

    public static MyProxy newInstance(MyInvocationHandler invocationHandler){
        MyProxy myProxy = new MyProxy();
        myProxy.invocationHandler=invocationHandler;
        return myProxy;
    }
}

class TestApp{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyProxy myProxy = MyProxy.newInstance(new MyInvocationHandler() {
            @Override
            public void invocat() {

            }
        });
        Constructor<DogInterface> constructor = DogInterface.class.getConstructor(null);
        constructor.newInstance(1,1);
    }
}
