package mao.gui.dong.db.jdbc2_0;


import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.zaxxer.hikari.HikariDataSource;
import mao.gui.dong.db.JdbcUtils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author maoguidong
 * jdbc2.0使用javax.datasource数据连接池实现
 */
public class JDBC2_0App {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet set=null;
        try {
            //1.mysql自带的datasource
            //connection=mysqlDatasource();
            mysqlConnectPoolDatasource();
            //2.druid的datasource
            //connection=druidDatasource();
            //3.hikari的datasource
            //connection=hikariDatasource();
            //hikaripooldatasource
            //hikaripool();
            //preparedStatement= connection.prepareStatement("select * from vehicle");
            //set=preparedStatement.executeQuery();
            //HikariProxyResultSet hikariProxyResultSet= (HikariProxyResultSet) set;
            //ResultSet delegate = hikariProxyResultSet.delegate;
            //JdbcUtils.parseResultSet(delegate);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    private static void hikaripool() {
        //ConnectionPoolDataSource
    }

    private static void mysqlConnectPoolDatasource() throws SQLException {
        ArrayList<PooledConnection> connections = new ArrayList<>();
        MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
        mysqlConnectionPoolDataSource.setDatabaseName("fms");
        mysqlConnectionPoolDataSource.setUser("root");
        mysqlConnectionPoolDataSource.setPassword("root");
        mysqlConnectionPoolDataSource.setDefaultFetchSize(10);
        mysqlConnectionPoolDataSource.setMaxReconnects(20);
        mysqlConnectionPoolDataSource.setUrl("jdbc:mysql://localhost:3306/fms");
        long l = System.currentTimeMillis();
        PooledConnection pooledConnection = mysqlConnectionPoolDataSource.getPooledConnection();

        long l1 = System.currentTimeMillis();
        System.out.println("mysqlPoolDatasource获取第一个链接："+(l1 - l));
        for (int i = 0; i < 10; i++) {
            connections.add(mysqlConnectionPoolDataSource.getPooledConnection());
        }
        long l2 = System.currentTimeMillis();
        System.out.println("mysqlPoolDatasource获取后10个链接："+(l2 - l1));
        for (PooledConnection connection : connections) {
            connection.close();
        }
        long l3 = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            mysqlConnectionPoolDataSource.getPooledConnection();
        }
        long l4 = System.currentTimeMillis();
        System.out.println("mysqlPoolDatasource销毁后10个链接："+(l4 - l3));
    }

    private static void datasourcePool() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        new DruidDataSource().getConnection();
        mysqlDataSource.getConnection();
    }

    private static Connection hikariDatasource() throws SQLException {
        ArrayList<Connection> connections = new ArrayList<>();
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("root");
        hikariDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/fms");
        hikariDataSource.setMaximumPoolSize(20);
        hikariDataSource.setMinimumIdle(11);
        long first = System.currentTimeMillis();
        hikariDataSource.getConnection();
        long firstend=System.currentTimeMillis();
        System.out.println("hikari_data创建一个链接用时："+(firstend-first));
        for (int i = 0; i < 10; i++) {
            connections.add(hikariDataSource.getConnection());
        }
        long last = System.currentTimeMillis();
        System.out.println("hikari_data创建后10个链接用时："+(last-firstend));
        for (Connection connection : connections) {
            connection.close();
        }
        long la = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            hikariDataSource.getConnection();
        }
        long lb = System.currentTimeMillis();
        System.out.println("hikari_data销毁后再创建10个链接用时："+(lb-la));
        return null;
    }


    private static Connection druidDatasource() throws SQLException {
        ArrayList<Connection> connections = new ArrayList<>();

        DruidDataSource source = new DruidDataSource();
        source.setUsername("root");
        source.setPassword("root");
        source.setUrl("jdbc:mysql://localhost:3306/fms");
        source.setMinIdle(2);
        source.setMaxActive(20);
        source.setDriver(new Driver());
        source.setInitialSize(10);
        long first = System.currentTimeMillis();
        source.getConnection();
        long firstend=System.currentTimeMillis();
        System.out.println("druid_data创建一个链接用时："+(firstend-first));
        for (int i = 0; i < 10; i++) {
            connections.add(source.getConnection());
        }
        long last = System.currentTimeMillis();
        System.out.println("druid_data创建后10个链接用时："+(last-firstend));

        for (Connection connection : connections) {
            connection.close();
        }

        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            source.getConnection();
        }
        long l1 = System.currentTimeMillis();
        System.out.println("销毁后再创建"+(l1 - l));
        return null;
    }

    private static Connection mysqlDatasource() throws SQLException {
        ArrayList<Connection> connections = new ArrayList<>();
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        //设置开始有10个链接
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");
        mysqlDataSource.setDatabaseName("fms");
        long first=System.currentTimeMillis();
         mysqlDataSource.getConnection();
         long firstend=System.currentTimeMillis();
        System.out.println("mysql_data创建一个链接用时："+(firstend-first));
        for (int i = 0; i < 10; i++) {
            connections.add(mysqlDataSource.getConnection());
        }
        long last = System.currentTimeMillis();
        System.out.println("mysql_data创建后10个链接用时："+(last-firstend));
        for (Connection connection : connections) {
            connection.close();
        }
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            mysqlDataSource.getConnection();
        }
        long l1 = System.currentTimeMillis();
        System.out.println("销毁后再创建："+(l1 - l));

        return null;
    }

    static void initContext(){
        try {
            InitialContext initialContext = new InitialContext();
            DataSource source = (DataSource) initialContext.lookup("java:com/env/jdbc/fms");
            Connection connection = source.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setDatabaseName("fms");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");
        Connection connection = null;
        try {
            connection = mysqlDataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from vehicle");
            ResultSet resultSet = preparedStatement.executeQuery();
            JdbcUtils.parseResultSet(resultSet);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
