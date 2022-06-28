package mao.gui.dong.myInterface;


import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maoguidong
 */
@Service
public class InterfaceService {

    private final List<BaseInterface> baseInterfaces;

    public InterfaceService(List<BaseInterface> baseInterfaces) {
        this.baseInterfaces = baseInterfaces;
    }

    public List<BaseInterface> getBaseInterfaces() {
        return baseInterfaces;
    }


}
