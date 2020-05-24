package com.dlnu.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dlnu.dao.GuestbookDao;
import com.dlnu.dao.UserDao;
import com.dlnu.pojo.Guestbook;
import com.dlnu.pojo.User;
import com.mysql.fabric.xmlrpc.base.Array;

public class GuestbookService {
	GuestbookDao dao = new GuestbookDao();
	UserDao uDao = new UserDao();

	public boolean addGuestbook(Guestbook gb) {
		return dao.insert(gb);
	}
	
	/**
	 * 	获取包括用户信息的留言表
	 * @return
	 */
	public List<Guestbook> getAll(){
		List<Guestbook> guestbooks = dao.getAll();
		List<Guestbook> guestbooks2 = new ArrayList<Guestbook>(); 
		for (Guestbook guestbook: guestbooks) {
			User user = uDao.queryById(guestbook.getuID());
			guestbook.setUser(user);
			String time = guestbook.getAddtime();
			guestbook.setAddtime(time.substring(0, time.length()-2));
			guestbooks2.add(guestbook);
		}
		return guestbooks2;
	}
	
	/**
	 * 删除留言表 by gbid
	 * @param gbid
	 * @return
	 */
	public boolean deleteGuestbook(int gbid) {
		int result = dao.deleteByGbid(gbid);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}
}
