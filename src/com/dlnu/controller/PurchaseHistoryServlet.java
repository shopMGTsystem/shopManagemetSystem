package com.dlnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlnu.pojo.Card;
import com.dlnu.pojo.Goods;
import com.dlnu.pojo.PurchaseHistory;
import com.dlnu.pojo.ShoppingCar;
import com.dlnu.pojo.User;
import com.dlnu.service.*;
import com.dlnu.util.PageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/purchaseHistory/*")
public class PurchaseHistoryServlet extends BaseServlet  {
	UserService uService = new UserService();
	CardService cService = new CardService();
	GoodsService gService = new GoodsService();
	ShoppingCarService scService = new ShoppingCarService();
	PurchaseHistoryService pService = new PurchaseHistoryService();
	
	//获取当前时间
	Calendar calendar= Calendar.getInstance(Locale.CHINA);// 设置北京时区
	//获取今日00：00
	//SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
	//String date1 = dateFormat1.format(calendar.getTime());
	//获取今日现在时间
	SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date2 = dateFormat2.format(calendar.getTime());
	
	/**
	 * 添加消费记录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean[] flag = {false,false,false,false};
		
		
		//从前台获取数据
		String username = request.getParameter("username");
		String listStr = request.getParameter("list");
		
		//前台选中的gid的集合
		List<Integer> gidList = chageToList(listStr);
		
		/**
		 * 从数据库中获取信息
		 */
		//通过username查找uid(user)
		User user = uService.queryUserByName(username);
		//记录总积分
		int totalPoint = 0;
		
		ShoppingCar[] cars = new ShoppingCar[gidList.size()];
		for (int i = 0; i < gidList.size(); i++) {
			flag[0] = true;
			//通过gid查找购物车中sCount(shoppingCar)
			ShoppingCar sc = new ShoppingCar(user.getuID(), gidList.get(i));
			cars[i] = scService.queryOneShoppingCarByIDs(sc);
			
			/**
			 * test
			 */
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			String jsonStr = gson.toJson(cars[i]);
			System.out.println(jsonStr);
			
			System.out.println("date2:"+date2);
			/**
			 * test end
			 */
		
			//通过gid查找商品中gpoint(goods)
			Goods goods = gService.queryGoodsById(gidList.get(i));
			
			System.out.println("sCount:"+cars[i].getsCount());
			System.out.println("gPoint:"+goods.getgPoint());
			
			totalPoint += cars[i].getsCount() * goods.getgPoint();
			
			//1.消费记录中 购买商品的增加
			PurchaseHistory ph = new PurchaseHistory(user.getuID(), gidList.get(i), cars[i].getsCount(), date2);
			boolean f = pService.addPurchaseHistory(ph);
			if (f == false) {
				flag[0] = false;
				break;
			}
		}
		
		System.out.println("消费记录中 购买商品的增加:"+flag[0]);
		
		//2.会员卡更新积分
		flag[1] = cService.updatePoint(user.getuID(),totalPoint);
		
		System.out.println("会员卡更新积分:"+flag[1]);
		
		
		//3.购物车中 购买商品的删除
		for (int i = 0; i < gidList.size(); i++) {
			flag[2] = true;
			boolean flag2 = scService.delShoppingCar(user.getuID(), gidList.get(i));
			if (flag2 == false) {
				flag[2] = false;
				break;
			}
		}
		
		System.out.println("购物车中 购买商品的删除:"+flag[2]);
		//判断1 2 3是否都正确执行
		for (int i = 0; i < 3; i++) {
			flag[3] = true;
			if (flag[i] == false) {
				flag[3] = false;
				break;
			}
		}
		System.out.println("前3个是否成功:"+flag[3]);
		out.print(flag[3]);
		
		out.close();
	}
	
	/**
	 * String转list
	 * 去除多余字符 " , [ ]
	 * @param str
	 * @return
	 */
	public List<Integer> chageToList(String str) {
		String subList = str.substring(1,str.length()-1);
        String[] result = subList.split(",");
        List<Integer> list = new ArrayList<>();
        for (String r : result) {
            //去掉多余双引号
            r = r.replaceAll("\\\"","");
            int rInt = Integer.parseInt(r);
            list.add(rInt);
        }
        return list;
	}
	
	
	/**
	 * 查询所有消费记录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllPurchaseHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
        PageBean<PurchaseHistory> pb = pService.query(currentPage,pageSize,user.getuID());
        //4.序列化参数
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(pb);
        //5. 将pageBean对象序列化，写回客户端
        out.print(jsonStr);
        
        System.out.println(jsonStr);
        
        out.close();
	}
}
