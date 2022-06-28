package mao.gui.dong.spring.ioc.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component(value = "cat")
public class CatDB implements BaseDB{
    @Override
    public String getAnimalName() {
        return "cat";
    }

    public void test(String... msgs){
        String[] strings=msgs;
        for (String string : strings) {
            System.out.println(string);
        }
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }
}
