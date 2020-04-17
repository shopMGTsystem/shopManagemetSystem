package com.dlnu.pojo;

/**
 * @author dell
 *
 */
public class Card {
	//会员卡ID
	private Integer cID;
	
	//会员ID， 外键  (实例化会员类)
	private User user;
	
	//会员积分数
	private Integer point;
	
	//会员等级
	private Integer level;
	
	


	public Card(Integer cID, User user, Integer point, Integer level) {
		super();
		this.cID = cID;
		this.user = user;
		this.point = point;
		this.level = level;
	}

	public Card(User user) {
		super();
		this.user = user;
	}

	public Integer getcID() {
		return cID;
	}

	public void setcID(Integer cID) {
		this.cID = cID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	
}
