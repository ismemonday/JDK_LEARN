package mao.gui.dong.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/7/18 下午3:14
 */
public class MgdKey extends SelectionKey {
    @Override
    public SelectableChannel channel() {
        return null;
    }

    @Override
    public Selector selector() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public void cancel() {

    }

    @Override
    public int interestOps() {
        return 0;
    }

    @Override
    public SelectionKey interestOps(int ops) {
        return null;
    }

    @Override
    public int readyOps() {
        return 0;
    }
}
