package com.dlnu.dao;

import com.dlnu.pojo.Guestbook;
import com.dlnu.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {
	
	public boolean insert(Guestbook gb) {
		Connection connection  = DBUtil.getConnection();
		String sql = "insert into tab_guestbook "
				+ "(uid,content,addtime) "
				+ "values (?,?,?)";
		
		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, gb.getuID());
			pstmt.setString(2, gb.getContent());
			pstmt.setString(3, gb.getAddtime());
			
			pstmt.executeUpdate();
			pstmt.close();
			connection.close();
			
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public int deleteByGbid(int gbid) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tab_guestbook where gbid = ?";
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gbid);
			int count = pstmt.executeUpdate();	
			pstmt.close();
			conn.close();
			
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public List<Guestbook> getAll() {
		Connection connection  = DBUtil.getConnection();
		String sql = "select gbid, uid, content, addtime, flag from tab_guestbook order by addtime desc";
		
		try {
			ArrayList<Guestbook> guestbooks = new ArrayList<Guestbook>();
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Guestbook guestbook = new Guestbook();
				guestbook.setGbID(rs.getInt(1));
				guestbook.setuID(rs.getInt(2));
				guestbook.setContent(rs.getString(3));
				guestbook.setAddtime(rs.getString(4));
				guestbook.setFlag(rs.getInt(5));
				
				guestbooks.add(guestbook);
			}
			pstmt.close();
			connection.close();
			
			return guestbooks;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
