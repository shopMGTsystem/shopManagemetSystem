package com.dlnu.pojo;

public class PurchaseHistory {
	//消费记录ID
	private Integer pID;
	
	//用户ID，外键  (实例化会员类)
	private User user;
	
	//商品ID，外键  (实例化商品类)
	private Goods goods;
	
	//购买数量
	private Integer pCount;
	
	//购买时间
	private String pTime;
	
	

	public PurchaseHistory(Integer pID, User user, Goods goods, Integer pCount, String pTime) {
		super();
		this.pID = pID;
		this.user = user;
		this.goods = goods;
		this.pCount = pCount;
		this.pTime = pTime;
	}

	public Integer getpID() {
		return pID;
	}

	public void setpID(Integer pID) {
		this.pID = pID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getpCount() {
		return pCount;
	}

	public void setpCount(Integer pCount) {
		this.pCount = pCount;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	
	
}
