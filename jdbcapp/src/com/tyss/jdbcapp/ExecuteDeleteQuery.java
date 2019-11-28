package com.tyss.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import com.mysql.jdbc.Driver;  no need from jdbc3

public class ExecuteDeleteQuery {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Step1:Load the Driver
			
//			Driver driver = new Driver();    no need from jdbc 3
//			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.jdbc.Driver");  //throws ClassNotFoundException
			
			//Step2:Get the Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn = DriverManager.getConnection(url);
			
			//Step3:Issue SQL query
			String sql = "delete from employee_info where id=?";
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
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
	}

}
