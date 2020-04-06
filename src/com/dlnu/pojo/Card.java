package com.dlnu.pojo;

public class Card {
	//会员卡ID
	private Integer cID;
	
	//会员等级
	private Integer level;
	
	//会员积分数
	private Integer point;

	public Card(Integer cID, Integer level, Integer point) {
		super();
		this.cID = cID;
		this.level = level;
		this.point = point;
	}

	public Integer getcID() {
		return cID;
	}

	public void setcID(Integer cID) {
		this.cID = cID;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}
	
}
