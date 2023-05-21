package com.ssafy.place.model.dto;

import com.ssafy.member.model.dto.MemberDto;

public class PlaceDto {
	private String no;
	private String lat;
	private String lon;
	private String title;
	private String content;
	private int hit;
	private String date;
	private String created_at;
	private String image;
	private MemberDto author;

	public PlaceDto(String no, String lat, String lon, String title, String content, int hit, String date,
			String created_at, String image, MemberDto author) {
		super();
		this.no = no;
		this.lat = lat;
		this.lon = lon;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.created_at = created_at;
		this.image = image;
		this.author = author;
	}

	public PlaceDto(String lat, String lon, String title, String content, String date, String image) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.title = title;
		this.content = content;
		this.date = date;
		this.image = image;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MemberDto getAuthor() {
		return author;
	}

	public void setAuthor(MemberDto author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "PlaceDto [no=" + no + ", lat=" + lat + ", lon=" + lon + ", title=" + title + ", content=" + content
				+ ", hit=" + hit + ", date=" + date + ", created_at=" + created_at + ", image=" + image + ", author="
				+ author + "]";
	}

}
