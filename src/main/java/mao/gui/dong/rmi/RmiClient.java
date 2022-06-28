package mao.gui.dong.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/4/12 下午7:42
 */
public class RmiClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Remote lookup = Naming.lookup("rmi://localhost:8888/user");
        System.out.println(lookup.toString());
    }
}
