package com.dlnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dlnu.pojo.PurchaseHistory;
import com.dlnu.pojo.ShoppingCar;
import com.dlnu.pojo.User;
import com.dlnu.util.DBUtil;

public class PurchaseHistoryDao {

	/**
	 * 添加购物记录
	 * @param ph
	 * @return
	 */
	public boolean insert(PurchaseHistory ph) {
		Connection connection  = DBUtil.getConnection();
		String sql = "insert into tab_purchasehistory "
				+ "(uid,gid,pcount,ptime) "
				+ "values (?,?,?,?)";
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, ph.getuID());
			pstmt.setInt(2, ph.getgID());
			pstmt.setInt(3, ph.getpCount());
			pstmt.setString(4, ph.getpTime());
			
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 查询总消费记录数
	 * @return
	 */
	public int findAll(int uid) {
		Connection conn = DBUtil.getConnection();
		String sql = "select count(*) from tab_purchasehistory where uid=?";
		int phCount = 0;//消费记录总数
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				phCount = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return phCount;
	}
	
	/**
	 * 查询所有消费的所有信息
	 * @param start
	 * @param pageSize
	 * @param uid
	 * @return
	 */
	public List<PurchaseHistory> query(int start, int pageSize, int uid){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_purchasehistory where uid=?  order by ptime limit ?,?";
		List<PurchaseHistory> list = new ArrayList<PurchaseHistory>();
		PurchaseHistory ph = null;
		try {
			//预处理sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setInt(2, start);
			pstmt.setInt(3, pageSize);
			//查询结果返回结果集
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ph = new PurchaseHistory(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				list.add(ph);
				System.out.println("db time有问题:"+rs.getString(5));
			}
				
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 通过购买时间查询消费记录
	 * @param ph
	 * @return
	 */
	public PurchaseHistory queryByPTime(PurchaseHistory ph){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_purchasehistory where uid=? and ptime like '"+ph.getpTime()+"%'";
		try {
			//预处理sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ph.getuID());
			//查询结果返回结果集
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ph = new PurchaseHistory(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
			}
				
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ph;
	}
	
	/**
	 * 查询beginDate~endDate的所有消费记录 
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<PurchaseHistory> queryByTimeZone(String beginDate, String endDate, User user){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_purchasehistory where uid=? and ptime between '"+beginDate+"' and '"+endDate+"'";
		List<PurchaseHistory> list = new ArrayList<PurchaseHistory>();
		PurchaseHistory ph = null;
		try {
			//预处理sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getuID());
			//查询结果返回结果集
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ph = new PurchaseHistory(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				list.add(ph);
			}
				
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
	
}
