package mao.gui.dong.design23.factory.generalFactory;

/**
 * 解决的问题？
 * ----可能有多个干一样事情的产品，并且这个产品还可能需要扩展
 * ----同类产品，做相同的东西
 * 1.首先找到一堆有特定的东西，抽象出来用接口
 * 2.工厂只负责创建不同的实现产品，这样扩展是只需要修改工厂类（开闭合原则）
 * @author maoguidong
 */
public class MessageFactory {
        Message getMessageFactory(String messageImpl){
            if("weixin".equals(messageImpl)){
                return new WeixinMessage();
            }else if("qq".equals(messageImpl)){
                return new QQMessage();
            }
            return null;
        }
}

 interface MyMessageFactory{
    Message createMessage();
}