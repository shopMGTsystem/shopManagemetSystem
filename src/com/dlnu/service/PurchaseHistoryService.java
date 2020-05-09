package com.dlnu.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlnu.dao.PurchaseHistoryDao;
import com.dlnu.pojo.Goods;
import com.dlnu.pojo.PurchaseHistory;
import com.dlnu.pojo.ShoppingCar;
import com.dlnu.pojo.User;
import com.dlnu.util.PageBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PurchaseHistoryService {
	
	PurchaseHistoryDao dao = new PurchaseHistoryDao();
	
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
	

}
