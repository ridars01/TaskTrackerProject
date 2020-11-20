package dev.fatimah.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtilTwo {

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/orcl" ; 
			String username = "hr" ; 
			String password = "oracle";
			Connection conn = DriverManager.getConnection(url , username , password);
			//System.out.println("Schema :"+ conn.getSchema());
			return conn ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}
	}

	

}
