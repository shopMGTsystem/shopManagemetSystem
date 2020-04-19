package com.dlnu.pojo;

public class User {
	//用户ID
	private Integer uID;

	//用户名
	private String userName;
	
	//用户密码
	private String password;
	
	//真实姓名
	private String realName;
	
	//性别
	private String sex;
	
	//生日
	private String birthday;
	
	//家庭住址
	private String address;
	
	//电话号码
	private String telephone;
	
	//邮箱
	private String email;
	
	//密保问题
	private String question;
	
	//密保回答
	private String answer;
	
	//注册时间
	private String signUpTime;
	
	

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}



	public User(String userName, String realName, String sex, String birthday, String address, String telephone,
			String email) {
		super();
		this.userName = userName;
		this.realName = realName;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}



	public User(Integer uID, String userName, String password, String realName, String sex, String birthday,
			String address, String telephone, String email, String question, String answer, String signUpTime) {
		super();
		this.uID = uID;
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.signUpTime = signUpTime;
	}
	
	
	
	public User(String userName, String password, String realName, String sex, String birthday, String address,
			String telephone, String email, String question, String answer, String signUpTime) {
		super();
		this.userName = userName;
		this.password = password;
		this.realName = realName;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.question = question;
		this.answer = answer;
		this.signUpTime = signUpTime;
	}



	public User() {
		// TODO Auto-generated constructor stub
	}



	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSignUpTime() {
		return signUpTime;
	}

	public void setSignUpTime(String signUpTime) {
		this.signUpTime = signUpTime;
	}
	
}
