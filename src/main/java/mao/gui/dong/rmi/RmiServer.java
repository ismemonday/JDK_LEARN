package mao.gui.dong.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/12 下午7:41
 */
public class RmiServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException, InterruptedException {
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/user", new UserService());
        Thread.sleep(60000);
        System.out.println("start server port is 8888");
    }
}
