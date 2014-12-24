package com.tieto.titan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:MySQL://localhost:3306/conan";

	// Database credentials
	static final String USER = "conan";
	static final String PWD = "conan";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Connecting to database...");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PWD);
		} catch (SQLException e) {
			System.out.println("Connection failed. Erorr message : " + e.getMessage());
		}
		
	}
	

	public static void main(String[] args) {
		DBUtils util = new DBUtils();
		String sql = "SELECT id,username,age,password FROM conan.user_info where id = ?";
		util.getConnection();
		util.query(sql,2);
		String sql2 = "update user_info set age=? where id=?";
		String [] strArr= {"29","2"};
		util.getConnection();
		util.update(sql2, strArr);
	}
	
	public void update(String sql,String[] strArr) {
		if(conn == null ) {
			return;
		}
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,strArr[0]);
			stmt.setString(2,strArr[1]);
			stmt.execute();
			System.out.println("update database successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(stmt != null) {
					stmt.close();
					stmt = null;
				}
				if(conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public void query(String sql,int userId) {
		if(conn == null ) {
			return;
		}
		System.out.println("Creating statement...");
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String age = rs.getString("age");
				String password = rs.getString("password");

				System.out.print("id: " + id);
				System.out.print(", username: " + username);
				System.out.print(", age: " + age);
				System.out.println(", password: " + password);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
					
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	}

}
