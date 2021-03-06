package com.dlnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dlnu.pojo.*;
import com.dlnu.util.*;

import sun.security.util.Password;


public class UserDao {
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public boolean updatePwdByUserame (User user) {
		Connection connection  = DBUtil.getConnection();
		String sql = "update tab_user "
				+ "set password=? "
				+ "where username=?";
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getUserName());
			
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 查询密码by用户名
	 * @param user
	 * @return
	 */
	public String queryPwdByUserame(User user){
		Connection conn = DBUtil.getConnection();
		String sql = "select password from tab_user where username = ?";
		String password = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				password = rs.getString(1);
			}
				
			rs.close();
			pstmt.close();
			conn.close();
			
			return password;
		} catch (SQLException e) {
			e.printStackTrace();
			return "false+-*/";
		}
		
	}
	
	/**
	 * 修改用户数据
	 * @param user
	 * @return
	 */
	public boolean update (User user) {
		Connection connection  = DBUtil.getConnection();
		String sql = "update tab_user "
				+ "set realname=?, sex=?, birthday=?, address=?, telephone=?, email=? "
				+ "where username=?";
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, user.getRealName());
			pstmt.setString(2, user.getSex());
			pstmt.setString(3, user.getBirthday());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getUserName());
			
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 插入用户数据
	 * 2020.4.7
	 */
	public int insert(User user) {
		Connection connection  = DBUtil.getConnection();
		String sql = "insert into tab_user "
				+ "(username,password,realname,sex,birthday,address,telephone,email,question,answer,signuptime) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getRealName());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getBirthday());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getTelephone());
			pstmt.setString(8, user.getEmail());
			pstmt.setString(9, user.getQuestion());
			pstmt.setString(10, user.getAnswer());
			pstmt.setString(11, user.getSignUpTime());
			
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			
			return 0;
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 通过uid查询
	 * @param uid
	 * @return
	 */
	public User queryById(int uid){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_user where uid = ?";
		User user = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
				
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 通过用户名查询
	 * 20202.4.7
	 * @param username
	 * @return User
	 */
	public User queryByName(String username){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_user where username = ?";
		User user = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			}
				
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}
	

	/**查询所有用户的所有信息
	 * @return
	 */
	public List<User> query(int start, int pageSize){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_user limit ?,?";
		List<User> list = new ArrayList<User>();
		User user = null;
		try {
			//预处理sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageSize);
			//查询结果返回结果集
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
				list.add(user);
			}
				
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
	
	/**查询总用户数量
	 * 
	 * @return
	 */
	public int findAll() {
		Connection conn = DBUtil.getConnection();
		String sql = "select count(*) from tab_user";
		int userCount = 0;//用户总数
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				userCount = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userCount;
	}
	
	/**查询总用户数量
	 * 
	 * @return
	 */
	public int findAllByTime(String time1, String time2) {
		Connection conn = DBUtil.getConnection();
		String sql = "select count(*) from tab_user where signuptime between '"+time1+"' and '"+time2+"'";
		int userCount = 0;//用户总数
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				userCount = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userCount;
	}
	
}


