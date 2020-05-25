package com.dlnu.service;

import com.dlnu.dao.GuestbookDao;
import com.dlnu.dao.ReplyDao;
import com.dlnu.dao.UserDao;
import com.dlnu.pojo.Guestbook;
import com.dlnu.pojo.Reply;
import com.dlnu.pojo.User;

public class ReplyService {

	ReplyDao dao = new ReplyDao();
	UserDao userDao = new UserDao();
	GuestbookDao gbDao = new GuestbookDao();
	
	public Reply getByGbid(int gbid) {
		Reply reply = dao.getByGbid(gbid);
		String time = reply.getReplytime();
		reply.setReplytime(time.substring(0, time.length()-2));

		User user = userDao.queryById(reply.getuID());
		Guestbook guestbook =gbDao.getOne(reply.getGbID());
		reply.setUser(user);
		reply.setGuestbook(guestbook);
		return reply;
	}
	
	/**
	 * 删除回复表 by gbid
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
	
	/**
	 * 添加回复表
	 * @param reply
	 * @return
	 */
	public boolean addReply(Reply reply) {
		return dao.insert(reply);
	}
}
