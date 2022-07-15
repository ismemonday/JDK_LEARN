package mao.gui.dong.design23.test;

import com.intelligt.modbus.jlibmodbus.net.stream.base.LoggingOutputStream;
import com.intelligt.modbus.jlibmodbus.net.stream.base.ModbusOutputStream;

import java.io.IOException;

/**
 * @author mgd [maoguidong@standard-robots.com]
 */
public class CaTest4 extends AbTest3 implements Test1{

    @Override
    public void m1(int a) {
        System.out.println("hello im in Cateest4");
        System.out.println(a);
    }

    public static void main(String[] args) throws IOException {
        LoggingOutputStream ls=null;
        ModbusOutputStream out = new LoggingOutputStream(new ModbusOutputStream() {
            @Override
            public void write(int b) throws IOException {
                super.write(b);
            }
        });
        out.write(1);

    }


}
