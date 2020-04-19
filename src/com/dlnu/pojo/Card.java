package com.dlnu.pojo;

/**
 * @author dell
 *
 */
public class Card {
	//会员卡ID
	private Integer cID;
	
	//会员id
	private Integer uID;
	
	//会员积分数
	private Integer point;
	
	//会员等级
	private Integer level;
	
	///会员ID， 外键  (实例化会员类)
	private User user;


	public Card() {
		super();
	}


	public Card(Integer uID) {
		super();
		this.uID = uID;
	}


	public Card(Integer cID, Integer uID, Integer point, Integer level) {
		super();
		this.cID = cID;
		this.uID = uID;
		this.point = point;
		this.level = level;
	}


	public Integer getcID() {
		return cID;
	}


	public void setcID(Integer cID) {
		this.cID = cID;
	}


	public Integer getuID() {
		return uID;
	}


	public void setuID(Integer uID) {
		this.uID = uID;
	}


	public Integer getPoint() {
		return point;
	}


	public void setPoint(Integer point) {
		this.point = point;
	}


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Card [cID=" + cID + ", uID=" + uID + ", point=" + point + ", level=" + level + "]";
	}

	

	
}
