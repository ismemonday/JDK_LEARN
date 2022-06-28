package mao.gui.dong.net.application.m_mao;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.*;
import java.net.spi.URLStreamHandlerProvider;

/**
 * @author maoguidong
 */
public class MaoStreamHandlerFactory extends URLStreamHandlerProvider{

    private final static String MAO_PROTOCOL= "mao";

    /**
     * Creates a new {@code URLStreamHandler} instance with the specified
     * protocol.
     *
     * @param protocol the protocol ("{@code ftp}",
     *                 "{@code http}", "{@code nntp}", etc.).
     * @return a {@code URLStreamHandler} for the specific protocol, or {@code
     * null} if this factory cannot create a handler for the specific
     * protocol
     * @see URLStreamHandler
     */
    @Override
    public  URLStreamHandler createURLStreamHandler(String protocol) {
        if(MAO_PROTOCOL.equals(protocol)){
            Object o = null;
            try {
                o = Class.forName("sun.net.www.protocol.http.Handler").getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return (URLStreamHandler)o;
        }
        return null;
    }
}
