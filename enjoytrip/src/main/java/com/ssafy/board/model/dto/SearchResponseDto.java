package com.ssafy.board.model.dto;

public class SearchResponseDto   {

	String img;
	String name;
	String address;
	String lat;
	String lon;
	String tel;
	String contentId;
	String overView;
	
	public SearchResponseDto() {}
	
	public SearchResponseDto(String img, String name, String address, String lat, String lon, String tel,
			String contentId, String overView) {
		super();
		this.img = img;
		this.name = name;
		this.address = address;
		this.lat = lat;
		this.lon = lon;
		this.tel = tel;
		this.contentId = contentId;
		this.overView = overView;
	}

	@Override
	public String toString() {
		return "SearchResponseDto [img=" + img + ", name=" + name + ", address=" + address + ", lat=" + lat + ", lon="
				+ lon + ", tel=" + tel + ", contentId=" + contentId + ", overView=" + overView + "]";
	}

	public String getContentId() {
		return contentId;
	}
	
	public void setContentId(String contentId) {
		this.contentId = contentId;
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

	public String getOverView() {
		return overView;
	}

	public void setOverView(String overView) {
		this.overView = overView;
	}
}
