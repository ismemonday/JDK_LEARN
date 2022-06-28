package mao.gui.dong.spring.aop.jdk.service.impl;

import mao.gui.dong.spring.aop.jdk.service.Animals;

/**
 * @author maoguidong
 */
public class DogImpl implements Animals {
    @Override
    public void call() {
        System.out.println("wang wang~~~~");
    }

    @Override
    public void eat() {
        System.out.println("eat shit");
    }
}
