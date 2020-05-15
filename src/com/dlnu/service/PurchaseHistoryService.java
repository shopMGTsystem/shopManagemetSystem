package com.dlnu.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlnu.dao.GoodsDao;
import com.dlnu.dao.PurchaseHistoryDao;
import com.dlnu.pojo.Goods;
import com.dlnu.pojo.PurchaseHistory;
import com.dlnu.pojo.ShoppingCar;
import com.dlnu.pojo.User;
import com.dlnu.util.PageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sun.security.tools.PathList;

public class PurchaseHistoryService {
	
	PurchaseHistoryDao dao = new PurchaseHistoryDao();
	GoodsDao goodsDao = new GoodsDao();
	
	/**
	 * 添加消费记录
	 * @param ph
	 * @return
	 */
	public boolean addPurchaseHistory(PurchaseHistory ph) {
		return dao.insert(ph);
	}
	
	/**
	 * 查询所有消费记录
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<PurchaseHistory> query(int currentPage, int pageSize, int uid){
		//封装pageBean
        PageBean<PurchaseHistory> pb = new PageBean<PurchaseHistory>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.findAll(uid);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1)*pageSize;   //开始的记录数
        List<PurchaseHistory> list = dao.query(start,pageSize,uid);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize)+1;
        pb.setTotalPage(totalPage);
		return pb;
	}
	
	public Double getTotalPriceByTimeZone(String beginDate, String endDate, User user){
		List<PurchaseHistory> phList = dao.queryByTimeZone(beginDate, endDate, user);
	
		double totalPrice = 0;
		for (int i = 0; i < phList.size(); i++) {
			//获取 购买数量
			int count = phList.get(i).getpCount();
			//获取 消费记录的gid
			int gid = phList.get(i).getgID();
			//根据gid获取商品的单价
			Goods goods = goodsDao.queryById(gid);
			Double price = goods.getgPrice();
			totalPrice += count * price;
		}
	
		return totalPrice;
		
	}

}
