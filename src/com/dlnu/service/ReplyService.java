package com.dlnu.service;

import java.util.List;

import com.dlnu.dao.ReplyDao;
import com.dlnu.pojo.Reply;
import com.sun.org.apache.bcel.internal.generic.DALOAD;

public class ReplyService {

	ReplyDao dao = new ReplyDao();
	
	public Reply getByGbid(int gbid) {
		Reply reply = dao.getByGbid(gbid);
		String time = reply.getReplytime();
		reply.setReplytime(time.substring(0, time.length()-2));
		return reply;
	}
	
	/**
	 * É¾³ý»Ø¸´±í by gbid
	 * @param gbid
	 * @return
	 */
	public boolean deleteReply(int gbid) {
		int result = dao.deleteByGbid(gbid);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}
}
