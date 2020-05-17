package com.dlnu.pojo;

public class Guestbook {
	//用户留言ID
	private Integer gbID;
	
	//会员id
	private Integer uID;
	
	//用户留言内容
	private String content;
	
	//用户留言时间
	private String addtime;
	
	//是否已被回复
	private boolean flag;
	
	///会员ID， 外键  (实例化会员类)
	private User user;

	


	public Guestbook(Integer uID, String content, String addtime) {
		super();
		this.uID = uID;
		this.content = content;
		this.addtime = addtime;
	}

	public Integer getGbID() {
		return gbID;
	}

	public void setGbID(Integer gbID) {
		this.gbID = gbID;
	}

	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
	
	
}
