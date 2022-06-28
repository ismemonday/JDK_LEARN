package mao.gui.dong.net.transport.m_tcp;

import java.nio.ByteBuffer;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/6 上午10:52
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.wrap(new byte[]{1, 2, 3, 45, 6, 5}, 0, 4);
        byte b = buff.get();
        buff.mark(); //标记positon和limit
        buff.get();
        buff.reset();//回到标记时候的
        byte b3 = buff.get();
        buff.remaining(); //返回limit-position
        buff.slice();//写过程中将剩余的buffer生成一个新的buffer
        buff.compact(); //把没写完的部分移动到最前面，重置position和limit为可读的状态,使用一个buffer又读又写的场景
        buff.duplicate();//在原有buff的基础上分裂出一个新的buffer,新的buffer跟原buffer互不影响，相互独立
        buff.rewind();//正在读过程中变更为重新读，正在写过程中变更为重新写（操作到一半时候丢弃）
        buff.clear();//重置为重新写
    }
}
