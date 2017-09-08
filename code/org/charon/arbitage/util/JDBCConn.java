package org.charon.arbitage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConn {

	//private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = null;// 设置连接字符串
	private static String username = null;//用户名
	private static String password = null;//密码
    Connection conn = null; //创建数据库连接对象

    public JDBCConn(){
    	if (url == null) {
//			url = SMSContext.getConfig().getSqlUrl();
//			username = SMSContext.getConfig().getSqlUsername();
//			password = SMSContext.getConfig().getSqlPassword();
    		url	= "jdbc:mysql://127.0.0.1:3306/arbitage?characterEncoding=utf-8";
    		username = "root";
    		password = "root";
		}
    }
    
	public Connection getConnection(){
		Connection conn = null; //创建数据库连接对象
        try {
            Class.forName(driver);
            // new oracle.jdbc.driver.OracleDriver();
            conn = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
	}
}
