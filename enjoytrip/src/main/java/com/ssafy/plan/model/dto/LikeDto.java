package com.ssafy.plan.model.dto;

public class LikeDto {

	String planLikesId;
	String planId;
	String userId;
	
	public LikeDto() {
		super();
	}

	public LikeDto(String planLikesId, String planId, String userId) {
		super();
		this.planLikesId = planLikesId;
		this.planId = planId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "LikeDto [planLikesId=" + planLikesId + ", planId=" + planId + ", userId=" + userId + "]";
	}
	
	
	
}
