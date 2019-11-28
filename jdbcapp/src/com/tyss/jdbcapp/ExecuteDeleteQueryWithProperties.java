package com.tyss.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

//import com.mysql.jdbc.Driver;  no need from jdbc3

public class ExecuteDeleteQueryWithProperties {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		FileReader reader = null;
		try {
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			//Step1:Load the Driver
			
//			Driver driver = new Driver();    no need from jdbc 3
//			DriverManager.registerDriver(driver);
			
			Class.forName(prop.getProperty("driver-class-name"));  //throws ClassNotFoundException
			
			//Step2:Get the Connection
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url,prop);
			
			//Step3:Issue SQL query
			String sql = prop.getProperty("delete-query");
			pstmt = conn.prepareStatement(sql);
			
//			String empid = args[0];
			pstmt.setInt(1, Integer.parseInt(args[0]));
			
			
			int count = pstmt.executeUpdate();
			
			//Step 4:Get the Result
			System.out.println(count+" Row(s) deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Step 5:Close all the Objects
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(reader!=null) {
					reader.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
