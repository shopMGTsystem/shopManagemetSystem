package com.dlnu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DBUtil {
	//加载驱动
	
		static{
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
		}
		
		//获取数据库连接
		public static Connection getConnection(){
			String url = "jdbc:mysql://localhost:3306/jf?useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password = "root";
			
			
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				//e.printStackTrace();
				System.err.println("打开数据库时出错: " + e.getMessage());
			}
			
			
			return con;
		}
		
		public static void main(String[] args){
			DBUtil.getConnection();
		}
		
	private Connection conn;
	private Statement stmt;
  	private DataSource ds;
	
	public DBUtil(){
	}

/*
	//	关闭数据库，将连接返还给连接池
	
	public void close() {
		try{
			conn.close();
			System.out.println ("释放连接");
		} 
		catch (SQLException ex) {
			System.err.println("返还连接池出错: " + ex.getMessage());
		}
	}

	
	//	执行查询
	public ResultSet executeQuery(String sql) throws SQLException{
		ResultSet rs = null;
		
		rs = stmt.executeQuery(sql);
		System.out.println ("执行查询");
		return rs;
	}


	//	执行增删改

	public int executeUpdate(String sql) throws SQLException{
		int ret = 0;
		
		ret = stmt.executeUpdate(sql);
	
		System.out.println ("执行增删改");
		return ret;
	}
*/
}
