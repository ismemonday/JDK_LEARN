package mao.gui.dong.spring.ioc.service;

import org.springframework.stereotype.Service;

@Service(value = "mao")
public class MaoServiceImpl implements BaseService{
    @Override
    public String getName() {
        return "mao";
    }
}
