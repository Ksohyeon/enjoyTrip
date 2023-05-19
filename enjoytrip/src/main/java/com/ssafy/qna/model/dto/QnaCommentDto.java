package com.ssafy.qna.model.dto;

import com.ssafy.member.model.dto.MemberDto;

public class QnaCommentDto {
	private String qnaNo;
	private String commentNo;
	private String commentContent;
	private String createdAt;
	private MemberDto author;
	

	
	public QnaCommentDto(String qnaNo, String commentNo, String commentContent, String createdAt, String userId, String nickName) {
		super();
		this.qnaNo = qnaNo;
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.createdAt = createdAt;
		this.author = new MemberDto(userId, nickName);
	}

	
	
	public QnaCommentDto(String qnaNo, String commentNo, String commentContent, MemberDto author) {
		super();
		this.qnaNo = qnaNo;
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.author = author;
	}
	

	public QnaCommentDto(String commentNo, String commentContent, MemberDto author) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.author = author;
	}
	
	

	public MemberDto getAuthor() {
		return author;
	}


	public void setAuthor(MemberDto author) {
		this.author = author;
	}

	public String getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(String qnaNo) {
		this.qnaNo = qnaNo;
	}

	@Override
	public String toString() {
		return "QnaCommentDto [qnaNo=" + qnaNo + ", commentNo=" + commentNo + ", commentContent=" + commentContent
				+ ", createdAt=" + createdAt + ", author=" + author + "]";
	}


	
}
