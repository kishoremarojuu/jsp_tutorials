package com.nit.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DriverConnection {
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
	}
	

}
