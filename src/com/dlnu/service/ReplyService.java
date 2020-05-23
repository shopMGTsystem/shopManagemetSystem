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
}