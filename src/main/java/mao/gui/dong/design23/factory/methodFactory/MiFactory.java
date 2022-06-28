package mao.gui.dong.design23.factory.methodFactory;

public class MiFactory implements MethodFactory{
    @Override
    public Message createProduct() {
        return new QQMessage();
    }
}
