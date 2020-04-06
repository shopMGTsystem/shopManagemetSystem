package com.dlnu.pojo;

public class PurchaseHistory {
	//消费记录ID
	private Integer pID;
	
	//购买数量
	private Integer pCount;
	
	//购买时间
	private String pTime;

	public PurchaseHistory(Integer pID, Integer pCount, String pTime) {
		super();
		this.pID = pID;
		this.pCount = pCount;
		this.pTime = pTime;
	}

	public Integer getpID() {
		return pID;
	}

	public void setpID(Integer pID) {
		this.pID = pID;
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
