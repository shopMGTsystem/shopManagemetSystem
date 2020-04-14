package com.dlnu.test;

import java.util.ArrayList;

import org.junit.Test;

import com.dlnu.dao.UserDao;
import com.dlnu.pojo.User;
import com.dlnu.service.UserService;

public class testUserDao {
	UserDao dao = new UserDao();
	private UserService Service = new UserService();
	/*
	@Test
	public void testInsert(){
		User user = new User("lisi", "Zxcv123","李四", "女","1996-08-05", "辽宁省沈阳市","15688925579","2@qq.com","2","密保答案2","2020-4-13 15:46");
		dao.insert(user);
	}
	
	@Test
	public void testQuery(){
		ArrayList<User> list = dao.query();
		for (User user :list){
			System.out.println(user.getUserName());
		}
	}
	*/
	/*
	@Test
	public void testQueryByName(){
		User user = dao.queryByName("lisis");
		System.out.println(user.getRealName());
				
	}
	*/
	/*
	@Test
	public void testQueryById(){
		User user = dao.queryById(100);
		System.out.println(user);
				
	}*/
	
	
	
	@Test
	public void testCheckLogin(){
		 
		int result = Service.checkLogin("admin", "123admin");
		System.out.println(result);
	}
	
}
