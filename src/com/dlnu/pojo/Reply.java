package com.dlnu.pojo;

public class Reply {
	//管理员回复ID
	private Integer ID;
	
	//管理员回复内容
	private String content;
	
	//管理员回复时间
	private String replytime;

	public Reply(Integer iD, String content, String replytime) {
		super();
		ID = iD;
		this.content = content;
		this.replytime = replytime;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
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
