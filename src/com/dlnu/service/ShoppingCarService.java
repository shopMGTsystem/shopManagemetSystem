package com.dlnu.service;

import java.util.List;

import com.dlnu.dao.ShoppingCarDao;
import com.dlnu.pojo.ShoppingCar;
import com.dlnu.pojo.User;
import com.dlnu.util.PageBean;

public class ShoppingCarService {
	
	ShoppingCarDao dao = new ShoppingCarDao();
	
	/**
	 * 	添加到购物车
	 * @param shoppingcar
	 * @return
	 */
	public boolean addShoppingCar(ShoppingCar shoppingcar){
		
		if (dao.queryByIDs(shoppingcar) == null) {
			//购物车里无此商品信息,添加新信息
			return dao.insert(shoppingcar);
	
		} else {
			//购物车里已有此商品，更新信息
			return dao.updateScountByGid(shoppingcar);
		}
		
	}
	
	/**
	 * 	删除购物车一条信息
	 * @param shoppingcar
	 * @return
	 */
	public boolean delShoppingCar(int uid, int gid){
		return dao.delete(uid, gid);
		
	}
	
	/**查询所有购物车信息
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<ShoppingCar> queryShoppingCarByUid(int currentPage, int pageSize, int uid){
		//封装pageBean
        PageBean<ShoppingCar> pb = new PageBean<ShoppingCar>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.findAll(uid);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1)*pageSize;   //开始的记录数
        List<ShoppingCar> list = dao.query(start,pageSize,uid);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize)+1;
        pb.setTotalPage(totalPage);
		return pb;
	}
	
	public ShoppingCar queryOneShoppingCarByIDs(ShoppingCar shoppingcar){
		return dao.queryByIDs(shoppingcar);
		
	}
	
}
