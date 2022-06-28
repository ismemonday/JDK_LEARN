package mao.gui.dong.db;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.protocol.a.result.ByteArrayRow;
import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author maoguidong
 */

public class JdbcUtils {
/**
     * 解析数据库查询
     * @param result
     */

    public static void parseResultSet(ResultSet result) {
        ResultSetImpl resultSet= (ResultSetImpl) result;
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = 10;
            ResultsetRowsStatic rows = (ResultsetRowsStatic) resultSet.getRows();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                System.out.print(columnName+"\t");
            }
            System.out.println("");
            System.out.println("=====================================================================================================");
            while (rows.hasNext()){
                ByteArrayRow row = (ByteArrayRow) rows.next();
                for (int i = 0; i < columnCount; i++) {
                    byte[] bytes = row.getBytes(i);
                    String s ="null";
                    if(bytes.length!=0){
                        s=new String(row.getBytes(i));
                    }
                    System.out.print(s+"\t");
                }
                System.out.println("");
                System.out.println("=====================================================================================================");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

