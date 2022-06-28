package mao.gui.dong.db.jdbc1_0;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maoguidong
 * @des jdbc1.0 drivermanager驱动管理硬编码模式操作数据库
 */
public class JDBC1_0App {
    public static void main(String[] args) {
        List<Connection> connections=new ArrayList<>();
        try {
            for (int i = 0; i < 100; i++) {
                DriverManager.getConnection("jdbc:mysql://localhost:3306/fms", "root", "root");
            }

            for (Connection connection : connections) {
                connection.close();
                Thread.sleep(2000);
            }

           /* ConnectionUrl connectionUrlInstance = ConnectionUrl.getConnectionUrlInstance("", new Properties());
            HostInfo mainHost = connectionUrlInstance.getMainHost();
            ConnectionImpl connection1 = new ConnectionImpl(mainHost);
            PreparedStatement preparedStatement = connection1.prepareStatement("select * from vehicle");
            boolean execute = preparedStatement.execute();*/

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void jdbc1Sessios(){
        Connection connection=null;
        try {
            //1.通过驱动管理获取与数据库的链接对象，在获取连接时，驱动管理会默认注册数据库驱动
            //mysql驱动：com.mysql.jdbc.Driver  url: jdbc:mysql://
            //oracle驱动： oracle.jdbc.driver.OracleDriver url: jdbc:oracle:thin:@
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/fms","root" ,"root" );
            //2.通过链接执行sql请求
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicle");
            ResultSet resultSet = preparedStatement.executeQuery();
            //3.解析ResultSet
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        Date.valueOf(LocalDate.now());
    }
}
