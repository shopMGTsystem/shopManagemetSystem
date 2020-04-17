package com.dlnu.test;

import org.junit.Test;

import com.dlnu.dao.CardDao;
import com.dlnu.pojo.Card;
import com.dlnu.pojo.User;

public class testCardDao {
	private CardDao dao = new CardDao();

	
	@Test
	public void testInsert(){
		User user = new User();
		user.setuID(1);
		Card card = new Card(user);
		dao.insert(card);
	}

}
