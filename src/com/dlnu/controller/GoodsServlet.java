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
	 * ���¿��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean flag = false;
		
		//��ǰ̨��ȡ����
		String gID_str = request.getParameter("gid");
		String gIn_str = request.getParameter("gin");
		
		//ת��Ϊ���ݿ��Ӧ��������
		int gID = Integer.parseInt(gID_str);
		int gIn = Integer.parseInt(gIn_str);
		
		//��װʵ����
		Goods goods = new Goods(gID, gIn);
		//����ҵ�����
		GoodsService gService = new GoodsService();
		flag = gService.updateStock(goods);
		System.out.println("from db:"+flag);
		
		out.print(flag);
	}
	
	/**
	 * ��������Ʒ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		boolean flag = false;
		//����ҵ�����
		GoodsService gService = new GoodsService();
		
		//��ǰ̨��ȡ����
		String gName = request.getParameter("gname");
		String gPrice_str = request.getParameter("gprice");
		String gPoint_str = request.getParameter("gpoint");
		String gIn_str = request.getParameter("gin");
		
		
		double gPrice = Double.parseDouble(gPrice_str);
		int gPoint = Integer.parseInt(gPoint_str);
		int gIn = Integer.parseInt(gIn_str);
		
		//�����ݷ�װ��Goodsʵ���� ��goodsû��gid
		Goods goods = new Goods(gName, gPrice, gPoint, gIn);
		//����������Ʒ����
		flag = gService.addGoods(goods);

		out.print(flag);
	}
	
	/**
	 * ��ѯ������Ʒ��Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		PrintWriter out = response.getWriter();
		//1.���ղ���
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
        //3. ����service��ѯPageBean����
        GoodsService gService = new GoodsService();
        PageBean<Goods> pb = gService.queryGoods(currentPage,pageSize);
        //4.���л�����
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String jsonStr = gson.toJson(pb);
        //5. ��pageBean�������л���д�ؿͻ���
        out.print(jsonStr);
	}
}