package mao.gui.dong.spring.ioc.service;

import mao.gui.dong.spring.ioc.dao.BaseDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;

@Service(value = "base")
public class BaseServiceImpl implements BaseService{

    @Autowired
    @Qualifier(value = "dog")
    private BaseDB baseDB;

    private File template;

    public BaseDB getBaseDB() {
        return baseDB;
    }

    public void setBaseDB(BaseDB baseDB) {
        this.baseDB = baseDB;
    }

    public File getTemplate() {
        return template;
    }

    public void setTemplate(File template) {
        this.template = template;
    }

    @Override
    public String getName() {
        return baseDB.getAnimalName();
    }
}
