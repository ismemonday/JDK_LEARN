package mao.gui.dong.spring.aop.jdk.service;

/**
 * 静态代理
 * @author maoguidong
 */
public  class ProxyAnimal implements Animals {

    private Animals animal;

    public ProxyAnimal(Animals animal) {
        this.animal = animal;
    }

    @Override
    public void call() {
        animal.call();
    }

    @Override
    public void eat() {

    }
}
