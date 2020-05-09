package com.dlnu.service;

import java.util.List;

import com.dlnu.dao.CardDao;
import com.dlnu.pojo.Card;
import com.dlnu.util.PageBean;

public class CardService {
	private CardDao dao = new CardDao();
	
	/**
	 */
	public boolean updatePoint(int uid, int point) {
		return dao.updatePoint(uid, point);
	}
	
	/**
	 * 通过uid查找会员卡信息
	 * @param uid
	 * @return
	 */
	public Card queryCardByUid(Integer uid){
		return dao.queryByUid(uid);
	}
	
	/**
	 * 添加会员卡
	 * @param card
	 */
	public void addCard(Card card){
		dao.insert(card);
	}
	
	/**
	 * 查询所有会员卡信息
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageBean<Card> queryCard(int currentPage, int pageSize){
		//封装pageBean
        PageBean<Card> pb = new PageBean<Card>();
        //设置当前页码
        pb.setCurrentPage(currentPage);
        //设置每页显示条数
        pb.setPageSize(pageSize);
        //设置总记录数
        int totalCount = dao.findAll();
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage-1)*pageSize;   //开始的记录数
        List<Card> list = dao.query(start,pageSize);
        pb.setList(list);

        //设置总页数 = 总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize)+1;
        pb.setTotalPage(totalPage);
		return pb;
	}
}
