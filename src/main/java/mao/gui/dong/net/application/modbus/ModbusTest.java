package mao.gui.dong.net.application.modbus;

import com.intelligt.modbus.jlibmodbus.exception.ModbusIOException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusNumberException;
import com.intelligt.modbus.jlibmodbus.exception.ModbusProtocolException;
import com.intelligt.modbus.jlibmodbus.master.ModbusMaster;
import com.intelligt.modbus.jlibmodbus.master.ModbusMasterFactory;
import com.intelligt.modbus.jlibmodbus.msg.ModbusRequestBuilder;
import com.intelligt.modbus.jlibmodbus.msg.base.ModbusResponse;
import com.intelligt.modbus.jlibmodbus.msg.response.ReadHoldingRegistersResponse;
import com.intelligt.modbus.jlibmodbus.tcp.TcpParameters;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author mgd [maoguidong@standard-robots.com]
 * @data 2022/6/30 上午11:36
 */

class ModbusTest {
    public static void main(String[] args) throws ModbusNumberException, ModbusProtocolException, ModbusIOException {

        onceSend();
        //containueSend();
    }

       void containueSend() {
        ModbusMaster modbusMasterTCP = ModbusMasterFactory.createModbusMasterTCP(new TcpParameters("10.10.68.72", 502, false));
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(()->{
            try {
                ModbusResponse modbusResponse = modbusMasterTCP.processRequest(ModbusRequestBuilder.getInstance().buildWriteSingleRegister(1,(int)((Math.random()*100)%10), (int)(Math.random()*100)));

            } catch (ModbusProtocolException e) {
                e.printStackTrace();
            } catch (ModbusNumberException e) {
                e.printStackTrace();
            } catch (ModbusIOException e) {
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    private static void onceSend() throws ModbusNumberException, ModbusIOException, ModbusProtocolException {
        //创建链接
        ModbusMaster modbusMasterTCP = ModbusMasterFactory.createModbusMasterTCP(new TcpParameters("10.10.68.72", 502, true));
        //发送数据&响应数据
        ModbusResponse modbusResponse = modbusMasterTCP.processRequest(ModbusRequestBuilder.getInstance().buildReadHoldingRegisters(1, 3, 1));
        ReadHoldingRegistersResponse resp= (ReadHoldingRegistersResponse) modbusResponse;
        byte[] bytes = resp.getBytes();
        ByteBuffer buff = ByteBuffer.wrap(bytes);
        while (buff.remaining()!=0){
            System.out.println(buff.getShort());
        }

    }
}
