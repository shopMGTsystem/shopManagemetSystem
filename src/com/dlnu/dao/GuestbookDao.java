package com.dlnu.dao;

import com.dlnu.pojo.Guestbook;
import com.dlnu.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
