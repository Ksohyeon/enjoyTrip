package com.ssafy.member.model.dto;

public class MemberDto {

	private String userId;
	private String nickName;
	private String userName;
	private String userPwd;
	private String emailId;
	private String emailDomain;
	private String joinDate;
	private int admin;
	
	public MemberDto() {}
	
	public MemberDto(String userId) {
		super();
		this.userId = userId;
	}

	public MemberDto(String userId, String userName, String userPwd, String emailId, String emailDomain,
			String joinDate, int admin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.joinDate = joinDate;
		this.admin = admin;
	}


	public MemberDto(String userId, String nickName, String userName, String userPwd, String emailId, String emailDomain,
			String joinDate) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.userName = userName;
		this.userPwd = userPwd;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.joinDate = joinDate;
	}
	
	public MemberDto(String userId, String nickName) {
		super();
		this.userId = userId;
		this.nickName = nickName;
	}

	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", emailId="
				+ emailId + ", emailDomain=" + emailDomain + ", joinDate=" + joinDate + ", admin=" + admin + "]";
	}

}
