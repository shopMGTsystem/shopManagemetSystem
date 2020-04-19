package com.dlnu.test;

import org.junit.Test;

import com.dlnu.dao.CardDao;
import com.dlnu.pojo.Card;
import com.dlnu.pojo.User;

public class testCardDao {
	private CardDao dao = new CardDao();

	@Test
	public void testQueryById(){
		dao.queryByUid(1);
	}
	@Test
	public void testInsert(){
		Card card = new Card();
		card.setuID(1);
		dao.insert(card);
	}

}
