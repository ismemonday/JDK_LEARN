package mao.gui.dong.spring.ioc.dao;

import org.springframework.stereotype.Component;

@Component(value = "dog")
public class dogDB implements BaseDB{
    @Override
    public String getAnimalName() {
        return "dog";
    }
}
