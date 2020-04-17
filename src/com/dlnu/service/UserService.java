package com.dlnu.service;

import java.util.ArrayList;
import java.util.List;

import com.dlnu.dao.UserDao;
import com.dlnu.pojo.User;
import com.dlnu.util.PageBean;

public class UserService {
	private UserDao dao = new UserDao();
	
	public int userCount() {
		return dao.findAll();
	}
	
	/**
	 * 查询date1-date2间 用户注册数量
	 * @param time1
	 * @param time2
	 * @return
	 */
	public int userCountByTime(String time1, String time2) {
		return dao.findAllByTime(time1, time2);
	}
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		int result = dao.insert(user);
		if (result != -1) { 
			return true; 
		}else {
			return false; 
		}
	}

	
	/**
	 * 通过uid查找用户信息
	 * @param userId
	 * @return
	 */
	public User queryUserById(Integer userId){
		return dao.queryById(userId);
	}
	
	/**
	 * 通过用户名查找用户信息
	 * @param username
	 * @return
	 */
	public User queryByName(String username){
		return dao.queryByName(username);
	}
	
	/**查询所有用户信息
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<User> queryUser(int currentPage, int pageSize){
		//封装pageBean
        PageBean<User> pb = new PageBean<User>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.findAll();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1)*pageSize;   //开始的记录数
        List<User> list = dao.query(start,pageSize);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize)+1;
        pb.setTotalPage(totalPage);
		return pb;
	}
	
	
	/**查看用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	public boolean checkUsernameExist(String username) {
		User user = dao.queryByName(username);
		if(user.getUserName().equals(username)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	/**检查用户名和密码是否正确
	 * @param username
	 * @param password
	 * @return
	 * 1.管理员的账号密码
	 * 2.用户名不存在
	 * 3.密码错误
	 * 4.密码正确、用户名存在
	 * -1:无意义
	 */
	public int checkLogin(String username,String password){
		
		User user = dao.queryByName(username);
		if(username.equals("admin") && password.equals("123admin")) {
			return 1;
		}else if(user == null){
			return 2;
		}else if(user.getPassword().equals(password) == false){
			return 3;
		}else if(user.getUserName().equals(username) == true){
			return 4;
		}else {
			return -1;
		}
	}
}
