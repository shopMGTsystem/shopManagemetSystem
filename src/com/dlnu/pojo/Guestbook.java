package com.dlnu.pojo;

public class Guestbook {
	//用户留言ID
	private Integer gbid;
	
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

	public Guestbook(Integer gbid, User user, String content, String addtime, boolean flag) {
		super();
		this.gbid = gbid;
		this.user = user;
		this.content = content;
		this.addtime = addtime;
		this.flag = flag;
	}

	public Integer getGbid() {
		return gbid;
	}

	public void setGbid(Integer gbid) {
		this.gbid = gbid;
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
