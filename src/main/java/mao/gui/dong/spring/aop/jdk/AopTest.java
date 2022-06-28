package mao.gui.dong.spring.aop.jdk;

import mao.gui.dong.spring.aop.jdk.service.Animals;
import mao.gui.dong.spring.aop.jdk.service.ProxyAnimal;
import mao.gui.dong.spring.aop.jdk.service.impl.DogImpl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * @author maoguidong
 */
public class AopTest {
    public static void main(String[] args) throws Exception {
        //staticProxy();
        //dynamicProxy();
        listenProperty();
    }

    private static void listenProperty() {
        PropertyChangeListener propertyChangeListener1 = new PropertyChangeListener();
        PropertyChangeListener propertyChangeListener2 = new PropertyChangeListener();
        PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(new Object());
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener1);
        propertyChangeSupport.addPropertyChangeListener(propertyChangeListener2);
        propertyChangeSupport.firePropertyChange("", 13, 16);
    }

    private static void staticProxy() {
        DogImpl dog = new DogImpl();
        ProxyAnimal proxyDog = new ProxyAnimal(dog);
        proxyDog.call();
    }

    /**
     * 动态代理
     */
    private static void dynamicProxy() throws InvocationTargetException, IllegalAccessException {
        DogImpl dog = new DogImpl();
        DogImpl cat = new DogImpl();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(cat, args);
                return null;
            }
        };
        Animals animalProxy = (Animals)Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), handler);
        animalProxy.call();
    }

}
class PropertyChangeListener implements java.beans.PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        evt.getOldValue();
        Object newValue = evt.getNewValue();
        System.out.println("监听到值变化");
    }
}
