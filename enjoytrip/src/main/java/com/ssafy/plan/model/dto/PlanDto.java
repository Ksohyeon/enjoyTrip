package com.ssafy.plan.model.dto;

import java.util.List;

import com.ssafy.member.model.dto.MemberDto;

public class PlanDto {
	private String no;
	private String title;
	private String content;
	private String startDate;
	private String endDate;
	private String createdAt;
	private int hit;
	private String theme;
	private MemberDto author;
	private List<AttrDto> places;
	
	
	
	public PlanDto() {}

	// 작성시 필요한 생성자
	public PlanDto(String title, String content, String startDate, String endDate, String theme, MemberDto author) {
		super();
		this.author = author;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.theme = theme;
	}

	// 리스트 읽을시 필요한 생성자
	public PlanDto(String no, String title, String startDate, String endDate, String createdAt,
			int hit, String theme, MemberDto author) {
		super();
		this.no = no;
		this.author = author;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.hit = hit;
		this.theme = theme;
	}

	// 디테일 읽을시 필요한 생성자
	public PlanDto(String no, String title, String content, String startDate, String endDate,
			String createdAt, int hit, String theme, MemberDto author) {
		super();
		this.no = no;
		this.author = author;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.hit = hit;
		this.theme = theme;
	}
	

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public MemberDto getAuthor() {
		return author;
	}
	public void setAuthor(MemberDto author) {
		this.author = author;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<AttrDto> getPlaces() {
		return places;
	}

	public void setPlaces(List<AttrDto> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "PlanDto [no=" + no + ", author=" + author + ", title=" + title + ", content=" + content + ", startDate="
				+ startDate + ", endDate=" + endDate + ", createdAt=" + createdAt + ", hit=" + hit + ", theme=" + theme
				+ ", places=" + places + "]";
	}
	
	
	
}
