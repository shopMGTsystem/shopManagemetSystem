package com.dlnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dlnu.pojo.Card;
import com.dlnu.pojo.User;
import com.dlnu.service.CardService;
import com.dlnu.service.UserService;
import com.dlnu.util.DateUtil;
import com.dlnu.util.PageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.bcel.internal.generic.DALOAD;


@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
	
	//获取当前时间
	Calendar calendar= Calendar.getInstance(Locale.CHINA);// 设置北京时区
	//获取今日00：00
	SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
	//String date1 = dateFormat1.format(calendar.getTime());
	//获取今日现在时间
	SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//String date2 = dateFormat2.format(calendar.getTime());
	
	public void queryUserCountByWeek(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> hashMap1 = new LinkedHashMap<String, Object>();

		Gson gson = new Gson();
		;
		for (int i = -7 ,c=1; i < 0; i++,c++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			//日期 yyyy-MM-dd
			String beginDate = dateFormat1.format(DateUtil.getBeginDayOfNDay(i));
			String endDate = dateFormat2.format(DateUtil.getEndDayOfNDay(i));
			//星期
			String weekDay = DateUtil.dateToWeek(beginDate);
			//这一天注册人数
			int count = allUserCountByDay(beginDate, endDate);
			
			hashMap.put("beginDate", beginDate);
			hashMap.put("weekDay", weekDay);
			hashMap.put("count", count);
			hashMap1.put("day"+c, hashMap);
					
		}
		
	//	System.out.println(hashMap1);
		String jsonStr = gson.toJson(hashMap1);
	//	System.out.println(jsonStr);
		
		//数据返回前台
		response.setContentType("text/html; charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonStr);	
		out.close();
	}
	
	
	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean flag = false;
		
		//从前台获取数据
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		//封装实体类
		User user = new User(username, realname, sex, birth, address, tel, email);
		//调用业务对象
		UserService uService = new UserService();
		flag = uService.updateUser(user);
		
		out.print(flag);
		out.close();
	}
	
	/**
	 * 检查旧密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkPwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int flag = -1;
		
		//从前台获取数据
		String username = request.getParameter("username");
		String oldpwd = request.getParameter("oldpwd");
		
		
		//调用业务对象
		UserService uService = new UserService();
		User user = uService.queryUserByName(username);
		
		//判断旧密码输入是否一致
		if (user.getPassword().equals(oldpwd)) {
			flag = 1;
		} 
		
		//返回客户端
		out.print(flag);
		out.close();
		
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean flag = false;
		
		//从前台获取数据
		String username = request.getParameter("username");
		String newpwd = request.getParameter("newpwd");
		System.out.println("newpwd:" + newpwd);
		
		//封装实体类
		User user = new User(username,newpwd);
		//调用业务对象
		UserService uService = new UserService();
		flag = uService.updatePwd(user);
		
		out.print(flag);
		out.close();
	}
	
	/**
	 * 通过username查找用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findUserByUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter out = response.getWriter();
		User user = new User();
		//获取用户名
		String username = request.getParameter("username");
		//调用业务对象
		UserService service = new UserService();
		user = service.queryUserByName(username);
		//序列化参数
		Gson gson = new Gson();
		String jsonStr = gson.toJson(user);
		//System.out.println(jsonStr);
		//数据返回前台
		out.print(jsonStr);	
		out.close();
	}
	
	/**
	 * 通过uid查找用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findUserByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter out = response.getWriter();
		User user = new User();
		//获取用户id
		String uID_str = request.getParameter("uID");
		int uID = Integer.parseInt(uID_str); 
		//调用业务对象
		UserService service = new UserService();
		user = service.queryUserById(uID);
		//序列化参数
		Gson gson = new Gson();
		String jsonStr = gson.toJson(user);
		//System.out.println(jsonStr);
		//数据返回前台
		out.print(jsonStr);	
		out.close();
	}
	
	
	
	/**
	 * 查询所有用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter out = response.getWriter();
		//1.接收参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        int currentPage = 0;
        int pageSize = 0;
        //2.处理参数
        if(currentPageStr != null && currentPageStr.length() > 0){
            currentPage = Integer.parseInt(currentPageStr);
        }else {
            currentPage = 1;
        }
        if(pageSizeStr != null && pageSizeStr.length() > 0){
            pageSize = Integer.parseInt(pageSizeStr);
        }else {
            pageSize = 10;
        }
        //3. 调用service查询PageBean对象
        UserService service = new UserService();
        PageBean<User> pb = service.queryUser(currentPage,pageSize);
        //4.序列化参数
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(pb);
        //5. 将pageBean对象序列化，写回客户端
        out.print(jsonStr);
        out.close();
	}

	
	/**
	 * 查询总注册用户数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchAllUserCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        // 调用service
        UserService service = new UserService();
        int count = service.userCount();
        //写回客户端
        out.print(count);
        out.close();
	}
	
	
	/**
	 * 查询今日注册用户数量
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchAllUserCountByDay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String todayBegin = dateFormat1.format(calendar.getTime());
		String todayEnd = dateFormat2.format(calendar.getTime());
//		String todayBegin = dateFormat1.format(DateUtil.getDayBegin());
//		String todayEnd = dateFormat1.format(DateUtil.getDayEnd());
        int count = allUserCountByDay(todayBegin, todayEnd);
        //写回客户端
        out.print(count);
        out.close();
	}
	
	public int allUserCountByDay(String date1, String date2) {
		int count = 0;
		// 调用service
        UserService service = new UserService();
        count = service.userCountByTime(date1, date2);
		return count;
	}
	
	
	/**
	 * 登录Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("auto_login");
		
		PrintWriter out = response.getWriter();
		
		//调用业务对象
		UserService service = new UserService();
		
		//调用登录功能
		int result = service.checkLogin(username, password);
//		System.out.println(result);
		//如果登陆成功,在session范围内存储用户名
		
		if(result==4){		
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
	
			if (autoLogin != null) {	
				Cookie cookie = new Cookie("AUTO_LOGIN",username+'-'+password);
                //设置cookie存活时间并绑定路径
                cookie.setMaxAge(60*60*24*3);
                cookie.setPath(request.getContextPath());
                //在响应中添加cookie，并返回给浏览器
                response.addCookie(cookie);
			}
		}
		
		out.print(result);
		out.close();
	}
	 
	
	
	/**
	 * 注册Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		boolean flag = false;
		//调用业务对象
		UserService uService = new UserService();
		CardService cService = new CardService();
		
		//从前台获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String question = request.getParameter("select");
		String answer = request.getParameter("answer");
		String signuptime = dateFormat2.format(calendar.getTime());;
		
//		System.out.println(" username:"+username+"\n signuptime"+signuptime);
		//将数据封装到User实体类 此user没有uid
		User user = new User(username, password, realname, sex, birth, address, tel, email, question, answer, signuptime);
		//调用增加用户函数
		flag = uService.addUser(user);
		
		/*add会员卡开始*/
		//调用 通过username查找uid。  此user2有uid，其他和user一样
		User user2 = uService.queryUserByName(username);
		Card card = new Card(user2.getuID());
		cService.addCard(card);
		/*add会员卡结束*/
		
		out.print(flag);
		out.close();
	}

	
	
	/**
	 * 检查用户名是否已存在
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
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
		out.close();
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.销毁session
        HttpSession session = request.getSession();
        session.removeAttribute("username");

        //2.销毁cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (Cookie c : cookies) {
                if (c.getName().equals("AUTO_LOGIN")){
                    //设置cookie存活时间为0
                    c.setMaxAge(0);
                    c.setPath(request.getContextPath());
                    //将cookie响应到前台
                    response.addCookie(c);
                    break;
                }
            }
        }

        //3.跳转登录页面
        response.sendRedirect(request.getContextPath()+"/login.html");

	}
}
