package com.ssafy.plan.model.dto;

public class AttrDto {
	String planNo;
	String attrNo;
	String img;
	String title;
	String address;
	String lat;
	String lon;
	String overView;
	int order;
	
	public AttrDto() {}

	// 읽을 시 필요한 생성자
	public AttrDto(String planNo, String attrNo, String img, String title, String address, String lat, String lon,
			String overView, int order) {
		this.planNo = planNo;
		this.attrNo = attrNo;
		this.img = img;
		this.title = title;
		this.address = address;
		this.lat = lat;
		this.lon = lon;
		this.overView = overView;
		this.order = order;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}


	public String getPlanNo() {
		return planNo;
	}

	public String getAttrNo() {
		return attrNo;
	}
	public void setAttrNo(String attrNo) {
		this.attrNo = attrNo;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "AttrDto [attrNo=" + attrNo + ", img=" + img + ", title=" + title + ", address=" + address + ", lat=" + lat
				+ ", lon=" + lon + ", overView=" + overView + ", order=" + order + "]";
	}
	
	
	
}
