package mao.gui.dong.design23.factory.methodFactory;

public class HuaWeiFactory implements MethodFactory{
    @Override
    public Message createProduct() {
        return new WeiXinMessage();
    }
}
