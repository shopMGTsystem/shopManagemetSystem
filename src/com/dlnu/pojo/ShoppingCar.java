package com.dlnu.pojo;

public class ShoppingCar {
	//会员ID
	private Integer uID;
	
	//商品ID
	private Integer gID;
	
	//购买数量
	private Integer sCount;
	
	//用户ID，外键  (实例化会员类)
	private User user;
	
	//商品ID，外键  (实例化商品类)
	private Goods goods;

	public ShoppingCar(Integer uID, Integer gID) {
		super();
		this.uID = uID;
		this.gID = gID;
	}

	public ShoppingCar(Integer uID, Integer gID, Integer sCount) {
		super();
		this.uID = uID;
		this.gID = gID;
		this.sCount = sCount;
	}

	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public Integer getgID() {
		return gID;
	}

	public void setgID(Integer gID) {
		this.gID = gID;
	}

	public Integer getsCount() {
		return sCount;
	}

	public void setsCount(Integer sCount) {
		this.sCount = sCount;
	}
	
	
}
