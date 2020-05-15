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
	
	//��ȡ��ǰʱ��
	Calendar calendar= Calendar.getInstance(Locale.CHINA);// ���ñ���ʱ��
	//��ȡ����00��00
	SimpleDateFormat dateFormat1= new SimpleDateFormat("yyyy-MM-dd");
	//String date1 = dateFormat1.format(calendar.getTime());
	//��ȡ��������ʱ��
	SimpleDateFormat dateFormat2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date2 = dateFormat2.format(calendar.getTime());
	
	public void queryTodayConsume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ǰ̨��ȡ����
		String username = request.getParameter("username");
		//ͨ��username����uid(user)
		User user = uService.queryUserByName(username);
		//��ȡ����Ŀ�ʼ�ͽ���ʱ��
		String beginDate = dateFormat1.format(DateUtil.getDayBegin());
		String endDate = dateFormat2.format(DateUtil.getDayEnd());
		//��ȡ����Ĺ����ܼ�
        double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
        //д�ؿͻ���
  		response.setContentType("text/html; charset=UTF-8");  
  		PrintWriter out = response.getWriter();
  		out.print(totalPrice);
  		out.close();
	}
	
	public void queryThisWeekConsume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ǰ̨��ȡ����
		String username = request.getParameter("username");
		//ͨ��username����uid(user)
		User user = uService.queryUserByName(username);
		//��ȡ���ܵĿ�ʼ�ͽ���ʱ��
		String beginDate = dateFormat1.format(DateUtil.getBeginDayOfWeek());
		String endDate = dateFormat2.format(DateUtil.getEndDayOfWeek());
		//��ȡ���ܵĹ����ܼ�
        double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
        //д�ؿͻ���
  		response.setContentType("text/html; charset=UTF-8");  
  		PrintWriter out = response.getWriter();
  		out.print(totalPrice);
  		out.close();
	}
	
	public void queryThisMonthConsume(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ǰ̨��ȡ����
		String username = request.getParameter("username");
		//ͨ��username����uid(user)
		User user = uService.queryUserByName(username);
		//��ȡ���µĿ�ʼ�ͽ���ʱ��
		String beginDate = dateFormat1.format(DateUtil.getBeginDayOfMonth());
		String endDate = dateFormat2.format(DateUtil.getEndDayOfMonth());
		//��ȡ���µĹ����ܼ�
        double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
        //д�ؿͻ���
  		response.setContentType("text/html; charset=UTF-8");  
  		PrintWriter out = response.getWriter();
  		out.print(totalPrice);
  		out.close();		
	}
	
	/**
	 * ��ѯ��ʮ�����ѽ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void queryConsumeByDay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> hashMap1 = new LinkedHashMap<String, Object>();
		Gson gson = new Gson();
		
		//��ǰ̨��ȡ����
		String username = request.getParameter("username");
		//ͨ��username����uid(user)
		User user = uService.queryUserByName(username);
		
		for (int i = -10 ,c=1; i < 0; i++,c++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			
			//��ȡÿһ������� yyyy-MM-dd
			String beginDate = dateFormat1.format(DateUtil.getBeginDayOfNDay(i));
			String endDate = dateFormat2.format(DateUtil.getEndDayOfNDay(i));
			//��ȡ����Ĺ����ܼ�
			Double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
		
			//���뵽hashmap;
			hashMap.put("date", beginDate.substring(5));
			hashMap.put("totalPrice", totalPrice);
			hashMap1.put("day"+c, hashMap);
			
		}
		
	//	System.out.println(hashMap1);
		String jsonStr = gson.toJson(hashMap1);
	//	System.out.println(jsonStr);
		
		//���ݷ���ǰ̨
		response.setContentType("text/html; charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonStr);	
		out.close();
	}
	
public void queryConsumeByMonth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, Object> hashMap1 = new LinkedHashMap<String, Object>();
		Gson gson = new Gson();
		
		//��ǰ̨��ȡ����
		String username = request.getParameter("username");
		//ͨ��username����uid(user)
		User user = uService.queryUserByName(username);
		
		for (int i = -6 ,c=1; i < 0; i++,c++) {
			
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			
			//��ȡÿһ������� yyyy-MM-dd 
			String beginDate = dateFormat1.format(DateUtil.getBeginDayOfNMonth(i));
			String endDate = dateFormat2.format(DateUtil.getEndDayOfNMonth(i));
		
			//��ȡ����Ĺ����ܼ�
			Double totalPrice = pService.getTotalPriceByTimeZone(beginDate, endDate, user);
			
			//���뵽hashmap;
			if (beginDate.substring(5, 7).startsWith("0")) {
				hashMap.put("month", beginDate.substring(6,7)+"��");
			} else {
				hashMap.put("month", beginDate.substring(5,7)+"��");
			}
			hashMap.put("totalPrice", totalPrice);
			hashMap1.put("month"+c, hashMap);
			
		}
		
		String jsonStr = gson.toJson(hashMap1);

		
		//���ݷ���ǰ̨
		response.setContentType("text/html; charset=UTF-8");  
		PrintWriter out = response.getWriter();
		out.print(jsonStr);	
		out.close();
	}
	
	/**
	 * �������Ѽ�¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean[] flag = {false,false,false,false};
		
		
		//��ǰ̨��ȡ����
		String username = request.getParameter("username");
		String listStr = request.getParameter("list");
		
		//ǰ̨ѡ�е�gid�ļ���
		List<Integer> gidList = chageToList(listStr);
		
		/**
		 * �����ݿ��л�ȡ��Ϣ
		 */
		//ͨ��username����uid(user)
		User user = uService.queryUserByName(username);
		//��¼�ܻ���
		int totalPoint = 0;
		
		ShoppingCar[] cars = new ShoppingCar[gidList.size()];
		for (int i = 0; i < gidList.size(); i++) {
			flag[0] = true;
			//ͨ��gid���ҹ��ﳵ��sCount(shoppingCar)
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
		
			//ͨ��gid������Ʒ��gpoint(goods)
			Goods goods = gService.queryGoodsById(gidList.get(i));
			
			
			totalPoint += cars[i].getsCount() * goods.getgPoint();
			
			//1.���Ѽ�¼�� ������Ʒ������
			PurchaseHistory ph = new PurchaseHistory(user.getuID(), gidList.get(i), cars[i].getsCount(), date2);
			boolean f = pService.addPurchaseHistory(ph);
			if (f == false) {
				flag[0] = false;
				break;
			}
		}
		
//		System.out.println("���Ѽ�¼�� ������Ʒ������:"+flag[0]);
		
		//2.��Ա�����»���
		flag[1] = cService.updatePoint(user.getuID(),totalPoint);
		
//		System.out.println("��Ա�����»���:"+flag[1]);
		
		
		//3.���ﳵ�� ������Ʒ��ɾ��
		for (int i = 0; i < gidList.size(); i++) {
			flag[2] = true;
			boolean flag2 = scService.delShoppingCar(user.getuID(), gidList.get(i));
			if (flag2 == false) {
				flag[2] = false;
				break;
			}
		}
		
//		System.out.println("���ﳵ�� ������Ʒ��ɾ��:"+flag[2]);
		//�ж�1 2 3�Ƿ���ȷִ��
		for (int i = 0; i < 3; i++) {
			flag[3] = true;
			if (flag[i] == false) {
				flag[3] = false;
				break;
			}
		}
//		System.out.println("ǰ3���Ƿ�ɹ�:"+flag[3]);
		out.print(flag[3]);
		
		out.close();
	}
	
	/**
	 * Stringתlist
	 * ȥ�������ַ� " , [ ]
	 * @param str
	 * @return
	 */
	public List<Integer> chageToList(String str) {
		String subList = str.substring(1,str.length()-1);
        String[] result = subList.split(",");
        List<Integer> list = new ArrayList<>();
        for (String r : result) {
            //ȥ������˫����
            r = r.replaceAll("\\\"","");
            int rInt = Integer.parseInt(r);
            list.add(rInt);
        }
        return list;
	}
	
	
	/**
	 * ��ѯ�������Ѽ�¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllPurchaseHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter out = response.getWriter();
		//1.���ղ���
		String username = request.getParameter("username");	
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        int currentPage = 0;
        int pageSize = 0;
        //2.��������
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
        //ͨ��username����uid(user)
  		UserService uService = new UserService();
  		User user = uService.queryUserByName(username);
        //3. ����service��ѯPageBean����
        PageBean<PurchaseHistory> pb = pService.query(currentPage,pageSize,user.getuID());
        //4.���л�����
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(pb);
        //5. ��pageBean�������л���д�ؿͻ���
        out.print(jsonStr);
        
       // System.out.println(jsonStr);
        
        out.close();
	}
}