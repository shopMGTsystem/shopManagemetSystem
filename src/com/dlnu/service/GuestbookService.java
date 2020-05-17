package com.dlnu.service;

import com.dlnu.dao.GuestbookDao;
import com.dlnu.pojo.Guestbook;

public class GuestbookService {
	GuestbookDao dao = new GuestbookDao();

	public boolean addGuestbook(Guestbook gb) {
		return dao.insert(gb);
	}
}
