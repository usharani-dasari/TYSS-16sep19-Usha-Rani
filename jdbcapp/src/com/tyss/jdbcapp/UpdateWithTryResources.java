package com.tyss.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class UpdateWithTryResources {
	public static void main(String[] args) {
		//FileReader implements Closeable
		try(FileReader reader = new FileReader("db.properties")){
			Properties prop = new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driver-class-name"));
			String url = prop.getProperty("url");
			String sql = prop.getProperty("update-query");
			
			try(Connection conn = DriverManager.getConnection(url,prop);
					PreparedStatement pstmt = conn.prepareStatement(sql)){
				    
				    String empid = args[0];
				    int id = Integer.parseInt(empid);
				    pstmt.setInt(4, id);
				    
				    int sal = Integer.parseInt(args[2]);
				    pstmt.setInt(2, id);
				    
				    String name = args[1];
				    pstmt.setString(1, name);
				    
				    String gender = args[3];
				    pstmt.setString(3, gender);
				    
					int count = pstmt.executeUpdate();
					System.out.println(count+"Row(s) effected");
						
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
