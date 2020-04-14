package com.dlnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlnu.pojo.User;
import com.dlnu.service.UserService;
import com.sun.org.apache.bcel.internal.generic.DALOAD;


@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
	
	private String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		//调用业务对象
		UserService service = new UserService();
		
		//调用登录功能
		int result = service.checkLogin(username, password);
		System.out.println(result);
		//如果登陆成功,在session范围内存储用户名
		/*
		if(result==4){		
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		}*/
		
		out.print(result);
	}
	
	public void checkUsernameExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得用户名
		String username = request.getParameter("username_input");
		
		PrintWriter out = response.getWriter();
		
		//调用业务对象
		UserService service = new UserService();
		
		/**
		 *  判断数据库里是否存在此用户名
		 * return: true / false
		 */
		boolean result = service.checkUsernameExist(username);
		
		out.print(result);
	}

	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		UserService service = new UserService();
		boolean flag = false;
		
		String username = request.getParameter("username_input");
		String password = request.getParameter("password_input");
		String realname = request.getParameter("realname_input");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth_input");
		String address = request.getParameter("address_input");
		String tel = request.getParameter("tel_input");
		String email = request.getParameter("email_input");
		String question = request.getParameter("select_input");
		String answer = request.getParameter("answer_input");
		String signuptime = date;
		
		User user = new User(username, password, realname, sex, birth, address, tel, email, question, answer, signuptime);
		
		flag = service.addUser(user);
		out.print(flag);
	}
}
