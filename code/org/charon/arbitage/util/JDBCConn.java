package org.charon.arbitage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConn {

	//private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = null;// ���������ַ���
	private static String username = null;//�û���
	private static String password = null;//����
    Connection conn = null; //�������ݿ����Ӷ���

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
		Connection conn = null; //�������ݿ����Ӷ���
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
