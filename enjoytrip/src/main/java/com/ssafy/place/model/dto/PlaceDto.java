package com.ssafy.place.model.dto;

public class PlaceDto {
	int placeno;
	String user_id;
	String lat;
	String lon;
	String title;
	String content;
	int hit;
	String date;
	String created_at;
	String image;
	
	public PlaceDto(int placeno, String user_id, String lat, String lon, String title, String content, int hit, String date,
			String created_at, String image) {
		super();
		this.placeno = placeno;
		this.user_id = user_id;
		this.lat = lat;
		this.lon = lon;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.created_at = created_at;
		this.image = image;
	}
	public int getPlaceno() {
		return placeno;
	}
	public void setPlaceno(int placeno) {
		this.placeno = placeno;
	}
	public String getId() {
		return user_id;
	}
	public void setId(String id) {
		this.user_id = id;
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

	@Override
	public String toString() {
		return "PlaceDto [placeno=" + placeno + ", user_id=" + user_id + ", lat=" + lat + ", lon=" + lon + ", title=" + title
				+ ", content=" + content + ", hit=" + hit + ", date=" + date + ", created_at=" + created_at + ", image="
				+ image + "]";
	}
}
