package com.dlnu.pojo;

public class Reply {
	//管理员回复ID
	private Integer rID;
	
	//留言ID
	private Integer gbID;
	
	//会员ID
	private Integer uID;
	
	//管理员回复内容
	private String content;
	
	//管理员回复时间
	private String replytime;

	//留言ID， 外键  (实例化留言类)
	private Guestbook guestbook;
	
	//会员ID， 外键  (实例化会员类)
	private User user;
		
	

	public Reply(Integer rID, Integer gbID, Integer uID, String content, String replytime) {
		super();
		this.rID = rID;
		this.gbID = gbID;
		this.uID = uID;
		this.content = content;
		this.replytime = replytime;
	}

	public Integer getrID() {
		return rID;
	}

	public void setrID(Integer rID) {
		this.rID = rID;
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

	public Guestbook getGuestbook() {
		return guestbook;
	}

	public void setGuestbook(Guestbook guestbook) {
		this.guestbook = guestbook;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplytime() {
		return replytime;
	}

	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}

	
}
