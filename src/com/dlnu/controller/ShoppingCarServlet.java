package com.dlnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlnu.dao.ShoppingCarDao;
import com.dlnu.pojo.Goods;
import com.dlnu.pojo.ShoppingCar;
import com.dlnu.pojo.User;
import com.dlnu.service.GoodsService;
import com.dlnu.service.ShoppingCarService;
import com.dlnu.service.UserService;
import com.dlnu.util.PageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/shoppingCar/*")
public class ShoppingCarServlet extends BaseServlet {
	
	/**
	 * 添加购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addShoppingCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean flag = false;
		
		//从前台获取数据
		String username = request.getParameter("username");
		String gID_str = request.getParameter("gid");
		String sCount_str = request.getParameter("scount");
		
		int gID = Integer.parseInt(gID_str);
		int sCount = Integer.parseInt(sCount_str);
		
		//调用业务对象
		ShoppingCarService sService = new ShoppingCarService();
		
		//通过username查找uid(user)
		UserService uService = new UserService();
		User user = uService.queryUserByName(username);
		
		//将数据封装到ShoppingCar实体类
		ShoppingCar car = new ShoppingCar(user.getuID(), gID, sCount);
		
		//调用添加到购物车函数
		flag = sService.addShoppingCar(car);

		out.print(flag);
	}
	
	/**
	 * 查询所有购物车信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllShoppingCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter out = response.getWriter();
		//1.接收参数
		String username = request.getParameter("username");	
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
        //通过username查找uid(user)
  		UserService uService = new UserService();
  		User user = uService.queryUserByName(username);
        //3. 调用service查询PageBean对象
        ShoppingCarService sService = new ShoppingCarService();
        PageBean<ShoppingCar> pb = sService.queryShoppingCar(currentPage,pageSize,user.getuID());
        //4.序列化参数
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(pb);
        //5. 将pageBean对象序列化，写回客户端
        out.print(jsonStr);
	}
	
	/**
	 * 删除购物车中一条信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delShoppingCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean flag = false;
		
		//从前台获取数据
		String username = request.getParameter("username");
		String gID_str = request.getParameter("gid");
		
		int gID = Integer.parseInt(gID_str);
		
		//调用业务对象
		ShoppingCarService sService = new ShoppingCarService();
		
		//通过username查找uid(user)
		UserService uService = new UserService();
		User user = uService.queryUserByName(username);
		
		//将数据封装到ShoppingCar实体类
		ShoppingCar car = new ShoppingCar(user.getuID(), gID);
		
		//调用添加到购物车函数
		flag = sService.delShoppingCar(car);

		out.print(flag);
	}

}
