package com.dlnu.pojo;

public class Goods {
	//商品ID
	private Integer gID;
	
	//商品名称
	private String gName;
	
	//商品价格
	private Integer gPrice;
	
	//商品库存
	private Integer gStock;

	public Goods(Integer gID, String gName, Integer gPrice, Integer gStock) {
		super();
		this.gID = gID;
		this.gName = gName;
		this.gPrice = gPrice;
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

	public Integer getgPrice() {
		return gPrice;
	}

	public void setgPrice(Integer gPrice) {
		this.gPrice = gPrice;
	}

	public Integer getgStock() {
		return gStock;
	}

	public void setgStock(Integer gStock) {
		this.gStock = gStock;
	}
	
	
}
