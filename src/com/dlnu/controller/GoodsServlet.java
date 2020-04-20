package com.dlnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlnu.pojo.Card;
import com.dlnu.pojo.Goods;
import com.dlnu.pojo.User;
import com.dlnu.service.CardService;
import com.dlnu.service.GoodsService;
import com.dlnu.service.UserService;
import com.dlnu.util.PageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/goods/*")
public class GoodsServlet extends BaseServlet {
	
	/**
	 * 注册Servlet
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		boolean flag = false;
		//调用业务对象
		GoodsService gService = new GoodsService();
		
		//从前台获取数据
		String gName = request.getParameter("gname");
		String gPrice_str = request.getParameter("gprice");
		String gPoint_str = request.getParameter("gpoint");
		String gIn_str = request.getParameter("gin");
		
		
		double gPrice = Double.valueOf(gPrice_str);
		int gPoint = Integer.valueOf(gPoint_str);
		int gIn = Integer.valueOf(gIn_str);
		
		//将数据封装到Goods实体类 此goods没有gid
		Goods goods = new Goods(gName, gPrice, gPoint, gIn);
		//调用增加用户函数
		flag = gService.addGoods(goods);

		out.print(flag);
	}
	
	/**
	 * 查询所有用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
        GoodsService gService = new GoodsService();
        PageBean<Goods> pb = gService.queryGoods(currentPage,pageSize);
        //4.序列化参数
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(pb);
        //5. 将pageBean对象序列化，写回客户端
        out.print(jsonStr);
	}
}
