package com.dlnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.dlnu.pojo.Card;
import com.dlnu.pojo.Reply;
import com.dlnu.util.DBUtil;
import com.mysql.fabric.xmlrpc.base.Array;

public class ReplyDao {
	
	public Reply getByGbid(int gbid) {
		Connection conn = DBUtil.getConnection();
		String sql = "select * from tab_reply where gbid = ?";
		Reply reply = null;
		try {

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gbid);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				reply = new Reply();
				reply.setrID(rs.getInt(1));
				reply.setGbID(rs.getInt(2));
				reply.setuID(rs.getInt(3));
				reply.setContent(rs.getString(4));
				reply.setReplytime(rs.getString(5));
				
			}
				
			pstmt.close();
			conn.close();
			
			return reply;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int deleteByGbid(int gbid) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from tab_reply where gbid = ?";
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
	
}
