package com.dlnu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlnu.pojo.Card;
import com.dlnu.pojo.User;
import com.dlnu.service.CardService;
import com.dlnu.service.UserService;
import com.dlnu.util.PageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/card/*")
public class CardServlet extends BaseServlet {
	
	/**
	 * 查询一个会员卡信息 by 用户名
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCardInfoByUsername (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		//接收参数
		String username = request.getParameter("username");
		System.out.println(username);
		//通过username查找uid(user)
		UserService uService = new UserService();
		User user = uService.queryUserByName(username);
		//通过uid查找会员卡信息
		CardService cService = new CardService();
		Card card = cService.queryCardByUid(user.getuID());
//		System.out.println(card.toString());
		//4.序列化参数
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(card);
		System.out.println(jsonStr);
        //5. 将pageBean对象序列化，写回客户端
		//会员卡信息，写回客户端
		out.print(jsonStr);
		out.close();
		
	}
	
	/**
	 * 查询所有会员卡信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void searchAllCard (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
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
        CardService service = new CardService();
        PageBean<Card> pb = service.queryCard(currentPage,pageSize);
        //4.序列化参数
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(pb);
        //5. 将pageBean对象序列化，写回客户端
        out.print(jsonStr);
        out.close();
	}

}
