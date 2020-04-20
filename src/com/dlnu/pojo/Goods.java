package com.dlnu.pojo;

public class Goods {
	//商品ID
	private Integer gID;
	
	//商品名称
	private String gName;
	
	//商品价格
	private Double gPrice;
	
	//商品积分
	private Integer gPoint;
	
	//商品库存
	private Integer gStock;

	public Goods(String gName, Double gPrice, Integer gPoint, Integer gStock) {
		super();
		this.gName = gName;
		this.gPrice = gPrice;
		this.gPoint = gPoint;
		this.gStock = gStock;
	}

	public Goods(Integer gID, String gName, Double gPrice, Integer gPoint, Integer gStock) {
		super();
		this.gID = gID;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gPoint = gPoint;
		this.gStock = gStock;
	}

	public Integer getgID() {
		return gID;
	}

	public void setgID(Integer gID) {
		this.gID = gID;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public Double getgPrice() {
		return gPrice;
	}

	public void setgPrice(Double gPrice) {
		this.gPrice = gPrice;
	}

	public Integer getgPoint() {
		return gPoint;
	}

	public void setgPoint(Integer gPoint) {
		this.gPoint = gPoint;
	}

	public Integer getgStock() {
		return gStock;
	}

	public void setgStock(Integer gStock) {
		this.gStock = gStock;
	}

}
