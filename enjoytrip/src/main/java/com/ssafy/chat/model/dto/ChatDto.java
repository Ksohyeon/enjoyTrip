package com.ssafy.chat.model.dto;





import java.sql.Timestamp;

import com.ssafy.member.model.dto.MemberDto;

public class ChatDto {

    private String message;
    private Timestamp sendAt;
    private String sido;
    private String userId;
    private String userNickName;

	
	ChatDto() {
	}


	public ChatDto(String message, Timestamp sendAt, String sido, String userId) {
		super();
		this.message = message;
		this.sendAt = sendAt;
		this.sido = sido;
		this.userId = userId;
	}

	
	
	public ChatDto(String message, Timestamp sendAt, String sido, String userId, String userNickName) {
		super();
		this.message = message;
		this.sendAt = sendAt;
		this.sido = sido;
		this.userId = userId;
		this.userNickName = userNickName;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getSendAt() {
		return sendAt;
	}

	public void setSendAt(Timestamp sendAt) {
		this.sendAt = sendAt;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}



	@Override
	public String toString() {
		return "ChatDto [message=" + message + ", sendAt=" + sendAt + ", sido=" + sido + ", userId=" + userId
				+ ", userNickName=" + userNickName + "]";
	}

	
    
	
}
