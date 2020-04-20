package com.dlnu.service;

import java.util.List;

import com.dlnu.dao.GoodsDao;
import com.dlnu.dao.UserDao;
import com.dlnu.pojo.Goods;
import com.dlnu.pojo.User;
import com.dlnu.util.PageBean;

public class GoodsService {
	private GoodsDao dao = new GoodsDao();
	
	/**
	 * 增加商品
	 * @param goods
	 * @return
	 */
	public boolean addGoods(Goods goods){
		int result = dao.insert(goods);
		if (result != -1) { 
			return true; 
		}else {
			return false; 
		}
	}
	
	/**查询所有商品信息
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Goods> queryGoods(int currentPage, int pageSize){
		//封装pageBean
        PageBean<Goods> pb = new PageBean<Goods>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.findAll();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1)*pageSize;   //开始的记录数
        List<Goods> list = dao.query(start,pageSize);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize)+1;
        pb.setTotalPage(totalPage);
		return pb;
	}
}
