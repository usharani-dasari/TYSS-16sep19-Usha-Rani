package com.tyss.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class ExecuteUpdateQueryWithProperties {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		FileReader reader = null;
		try {
			
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			//Step 1:Load the Driver
			
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			
			Class.forName(prop.getProperty("driver-class-name"));
			
			//Step 2:Get the Connection
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url,prop);
			
			//Step 3: Issue SQL query
			String sql = prop.getProperty("update-query");
			pstmt = conn.prepareStatement(sql);
			
			String empid = args[0];
			int id = Integer.parseInt(empid);
			
			String name = args[1];
			
			String empsal = args[2];
			int sal = Integer.parseInt(empsal);
			
			String gender = args[3];
			
			pstmt.setInt(4, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, sal);
			pstmt.setString(3, gender);
			
			
		
			int count = pstmt.executeUpdate();
			
			//Step4:Read the Result
			System.out.println(count+" Row(s) effected");
			
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
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
