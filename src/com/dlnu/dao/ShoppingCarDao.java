package com.dlnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dlnu.pojo.Goods;
import com.dlnu.pojo.ShoppingCar;
import com.dlnu.pojo.User;
import com.dlnu.util.DBUtil;

public class ShoppingCarDao {
	
	/**
	 * 添加进购物车
	 * @param shoppingCar
	 * @return
	 */
	public boolean insert(ShoppingCar shoppingCar) {
		Connection connection  = DBUtil.getConnection();
		String sql = "insert into tab_shoppingcar "
				+ "(uid,gid,scount) "
				+ "values (?,?,?)";
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, shoppingCar.getuID());
			pstmt.setInt(2, shoppingCar.getgID());
			pstmt.setInt(3, shoppingCar.getsCount());
			
			
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return false;
	}
	
	/**查询购物车总数量
	 * 
	 * @return
	 */
	public int findAll(int uid) {
		Connection conn = DBUtil.getConnection();
		String sql = "select count(*) from tab_shoppingcar where uid=?";
		int carCount = 0;//购物车总数
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				carCount = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return carCount;
	}
	
	/**
	 * 查询所有商品的所有信息
	 * @param start
	 * @param pageSize
	 * @param uid
	 * @return
	 */
	public List<ShoppingCar> query(int start, int pageSize, int uid){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_shoppingcar where uid=? limit ?,? ";
		List<ShoppingCar> list = new ArrayList<ShoppingCar>();
		ShoppingCar shoppingcar = null;
		try {
			//预处理sql
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.setInt(2, start);
			pstmt.setInt(3, pageSize);
			//查询结果返回结果集
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				shoppingcar = new ShoppingCar(rs.getInt(1),rs.getInt(2),rs.getInt(3));
				list.add(shoppingcar);
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
	 * 通过gid查询
	 * @param uid
	 * @return
	 */
	public ShoppingCar queryByIDs(ShoppingCar shoppingCar){
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_shoppingcar where gid = ? and uid = ?";
		ShoppingCar shoppingcar = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shoppingCar.getgID());
			pstmt.setInt(2, shoppingCar.getuID());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				shoppingcar = new ShoppingCar(rs.getInt(1),rs.getInt(2),rs.getInt(3));
			}
				
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return shoppingcar;
	}
	
	/**
	 * 更新购买数量
	 * @param user
	 * @return
	 */
	public boolean updateScountByGid (ShoppingCar shoppingCar) {
		Connection connection  = DBUtil.getConnection();
		String sql = "update tab_shoppingcar "
				+ "set scount=scount+? "
				+ "where gid=? and uid=?";
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, shoppingCar.getsCount());
			pstmt.setInt(2, shoppingCar.getgID());
			pstmt.setInt(3, shoppingCar.getuID());
			
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
	 * 删除购物车中一条信息
	 * @param shoppingCar
	 */
	public boolean delete(int uid, int gid){
		Connection con = DBUtil.getConnection();
		String sql = "delete from tab_shoppingcar where gid=? and uid=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gid);
			pstmt.setInt(2, uid);
			
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
