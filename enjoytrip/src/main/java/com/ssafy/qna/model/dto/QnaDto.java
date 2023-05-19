package com.ssafy.qna.model.dto;

import com.ssafy.member.model.dto.MemberDto;

public class QnaDto {
	private String no;
	private String title;
	private String content;
	private String category;
	private String createdAt;
	private MemberDto author;
	
	public QnaDto() {}
	public QnaDto(String no, String title, String content, String category, String createdAt, MemberDto author) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.category = category;
		this.createdAt = createdAt;
		this.author = author;
	}

	public MemberDto getAuthor() {
		return author;
	}
	public void setAuthor(MemberDto author) {
		this.author = author;
	}
	public QnaDto(String title, String content, String category, MemberDto author) { 
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.author = author;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "QnaDto [no=" + no + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", createdAt=" + createdAt + ", author=" + author + "]";
	}
	
	
}
