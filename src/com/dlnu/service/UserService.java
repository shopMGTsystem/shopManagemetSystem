package com.dlnu.service;

import java.util.ArrayList;

import com.dlnu.dao.UserDao;
import com.dlnu.pojo.User;

public class UserService {
	private UserDao dao = new UserDao();
	public void addUser(User user){
		dao.insert(user);
	}
	
	/*
	public User queryUserById(Integer userId){
		return dao.queryById(userId);
	}
	
	public ArrayList<User> queryUser(){
		return dao.query();
	}
	*/
	/**
	 *   检查用户名和密码
	 *   返回值
	 * 1.管理员的账号密码
	 * 2.用户名不存在
	 * 3.密码错误
	 * 4.密码正确前提下的用户名存在
	 * -1:无意义
	 */
	public int checkLogin(String username,String password){
		
		User user = dao.queryByName(username);
		if(username == "admin" && password == "123admin") {
			return 1;
		}else if(dao.queryByName(username) == null){
			return 2;
		}else if(!user.getPassword().equals(password)){
			return 3;
		}else if(dao.queryByName(username).equals(username)){
			return 4;
		}else {
			return -1;
		}
	}
}
