package com.dlnu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.dlnu.util.DateUtil;
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
	SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
	//String date1 = dateFormat1.format(calendar.getTime());
	//获取今日现在时间
	SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date2 = dateFormat2.format(calendar.getTime());
	
	public void queryTodayConsume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从前台获取数据
		String username = request.getParameter("username");
		//通过username查找uid(user)
		User user = uService.queryUserByName(username);
		//获取今天的开始和结束时间
		String beginDate = dateFormat1.format(DateUtil.getDayBegin());
		String endDate = dateFormat2.format(DateUtil.getDayEnd());
		//获取今天的购物总价
        double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
        //写回客户端
  		response.setContentType("text/html; charset=UTF-8");  
  		PrintWriter out = response.getWriter();
  		out.print(totalPrice);
  		out.close();
	}
	
	public void queryThisWeekConsume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从前台获取数据
		String username = request.getParameter("username");
		//通过username查找uid(user)
		User user = uService.queryUserByName(username);
		//获取本周的开始和结束时间
		String beginDate = dateFormat1.format(DateUtil.getBeginDayOfWeek());
		String endDate = dateFormat2.format(DateUtil.getEndDayOfWeek());
		//获取本周的购物总价
        double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
        //写回客户端
  		response.setContentType("text/html; charset=UTF-8");  
  		PrintWriter out = response.getWriter();
  		out.print(totalPrice);
  		out.close();
	}
	
	public void queryThisMonthConsume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从前台获取数据
		String username = request.getParameter("username");
		//通过username查找uid(user)
		User user = uService.queryUserByName(username);
		//获取本月的开始和结束时间
		String beginDate = dateFormat1.format(DateUtil.getBeginDayOfMonth());
		String endDate = dateFormat2.format(DateUtil.getEndDayOfMonth());
		//获取本月的购物总价
        double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
        //写回客户端
  		response.setContentType("text/html; charset=UTF-8");  
  		PrintWriter out = response.getWriter();
  		out.print(totalPrice);
  		out.close();		
	}
	
	/**
	 * 查询近十天消费金额
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryConsumeByDay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> hashMap1 = new LinkedHashMap<String, Object>();
		Gson gson = new Gson();
		
		//从前台获取数据
		String username = request.getParameter("username");
		//通过username查找uid(user)
		User user = uService.queryUserByName(username);
		
		for (int i = -10 ,c=1; i < 0; i++,c++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			
			//获取每一天的日期 yyyy-MM-dd
			String beginDate = dateFormat1.format(DateUtil.getBeginDayOfNDay(i));
			String endDate = dateFormat2.format(DateUtil.getEndDayOfNDay(i));
			//获取当天的购物总价
			Double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
		
			//加入到hashmap;
			hashMap.put("date", beginDate.substring(5));
			hashMap.put("totalPrice", totalPrice);
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
	
public void queryConsumeByMonth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> hashMap1 = new LinkedHashMap<String, Object>();
		Gson gson = new Gson();
		
		//从前台获取数据
		String username = request.getParameter("username");
		//通过username查找uid(user)
		User user = uService.queryUserByName(username);
		
		for (int i = -6 ,c=1; i < 0; i++,c++) {
			
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			
			//获取每一天的日期 yyyy-MM-dd 
			String beginDate = dateFormat1.format(DateUtil.getBeginDayOfNMonth(i));
			String endDate = dateFormat2.format(DateUtil.getEndDayOfNMonth(i));
		
			//获取当天的购物总价
			Double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
			
			//加入到hashmap;
			if (beginDate.substring(5, 7).startsWith("0")) {
				hashMap.put("month", beginDate.substring(6,7)+"月");
			} else {
				hashMap.put("month", beginDate.substring(5,7)+"月");
			}
			hashMap.put("totalPrice", totalPrice);
			hashMap1.put("month"+c, hashMap);
			
		}
		
		String jsonStr = gson.toJson(hashMap1);

		
		//数据返回前台
		response.setContentType("text/html; charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonStr);	
		out.close();
	}
	
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
//			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//			String jsonStr = gson.toJson(cars[i]);
//			System.out.println(jsonStr);
//			
//			System.out.println("date2:"+date2);
			/**
			 * test end
			 */
		
			//通过gid查找商品中gpoint(goods)
			Goods goods = gService.queryGoodsById(gidList.get(i));
			
			
			totalPoint += cars[i].getsCount() * goods.getgPoint();
			
			//1.消费记录中 购买商品的增加
			PurchaseHistory ph = new PurchaseHistory(user.getuID(), gidList.get(i), cars[i].getsCount(), date2);
			boolean f = pService.addPurchaseHistory(ph);
			if (f == false) {
				flag[0] = false;
				break;
			}
		}
		
//		System.out.println("消费记录中 购买商品的增加:"+flag[0]);
		
		//2.会员卡更新积分
		flag[1] = cService.updatePoint(user.getuID(),totalPoint);
		
//		System.out.println("会员卡更新积分:"+flag[1]);
		
		
		//3.购物车中 购买商品的删除
		for (int i = 0; i < gidList.size(); i++) {
			flag[2] = true;
			boolean flag2 = scService.delShoppingCar(user.getuID(), gidList.get(i));
			if (flag2 == false) {
				flag[2] = false;
				break;
			}
		}
		
//		System.out.println("购物车中 购买商品的删除:"+flag[2]);
		//判断1 2 3是否都正确执行
		for (int i = 0; i < 3; i++) {
			flag[3] = true;
			if (flag[i] == false) {
				flag[3] = false;
				break;
			}
		}
//		System.out.println("前3个是否成功:"+flag[3]);
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
        
       // System.out.println(jsonStr);
        
        out.close();
	}
}
