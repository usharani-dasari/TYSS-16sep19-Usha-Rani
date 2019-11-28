package com.tyss.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class ExecuteUpdateQuery {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Step 1:Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2:Get the Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			conn = DriverManager.getConnection(url);
			
			//Step 3: Issue SQL query
			String sql = "Update employee_info set name=?,sal=?,gender=? where id=?";
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
			
		} catch (SQLException e) {
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
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
