package com.tyss.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from employee_info where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//Step1:Load the Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step2:Get the Connection
			conn = DriverManager.getConnection(url);
			
			//Step4:Issue SQL query
			pstmt = conn.prepareStatement(sql);
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int emp_id = rs.getInt("id");
				int sal = rs.getInt("sal");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				System.out.println("Id is "+emp_id);
				System.out.println("Salary: "+sal);
				System.out.println("Name is: "+name);
				System.out.println("Gender is: "+gender);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//Step5:Close all the objects
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

}
