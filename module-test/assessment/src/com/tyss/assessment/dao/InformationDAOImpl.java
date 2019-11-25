package com.tyss.assessment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tyss.assessment.dto.InformationBean;

public class InformationDAOImpl implements InformationDAO {
	
	public List<String> getAllContactNames(){
		
		String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
		String sql = "select name from Contact";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<String> result = new ArrayList<String>();
			
			while(rs.next()) {
				String name = rs.getString("name");
				result.add(name);
				
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//end of try-catch-finally
		
		
	}//end of getAllContactNames()
	public InformationBean searchForContact(String name) {
		String url = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
		String sql = "select * from Contact where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				InformationBean bean = new InformationBean();
			
				bean.setName(rs.getString("name"));
				bean.setNumber(rs.getInt("number"));
				bean.setGroups(rs.getString("groups"));
				return bean;
				
			}else {
			return null;
			}
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}//end of try-catch-finally
		
	}//end of searchForContact()
	
	

}//end of class
