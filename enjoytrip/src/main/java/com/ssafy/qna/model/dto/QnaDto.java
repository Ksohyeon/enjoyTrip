package com.ssafy.qna.model.dto;

public class QnaDto {
	
	private String user_id;
	private String qnano;
	private String subject;
	private String content;
	
	public QnaDto() {
		super();
	}

	public QnaDto(String userId, String qnano, String subject, String content) {
		super();
		this.user_id = userId;
		this.qnano = qnano;
		this.subject = subject;
		this.content = content;
	}

	public String getUserId() {
		return user_id;
	}

	public void setUserId(String userId) {
		this.user_id = userId;
	}

	public String getQnano() {
		return qnano;
	}

	public void setQnano(String qnano) {
		this.qnano = qnano;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "QnaDto [userId=" + user_id + ", qnano=" + qnano + ", subject=" + subject + ", content=" + content + "]";
	}

	
}
