package com.ssafy.board.model.dto;

public class SearchResponseDtoImpl   {

	String img;
	String name;
	String address;
	String lat;
	String lon;
	String tel;
	
	public SearchResponseDtoImpl() {}
	
	public SearchResponseDtoImpl(String img, String name, String address, String lat, String lon, String tel) {
		super();
		this.img = img;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lon = lon;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "SearchResponseDtoImpl [img=" + img + ", name=" + name + ", address=" + address + ", lat=" + lat
				+ ", lon=" + lon + ", tel=" + tel + "]";
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
