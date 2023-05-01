package com.ssafy.board.model.dto;

public class SearchRequestDtoImpl {
	
	String sido;
	String category;
	String keyword;
	
	public SearchRequestDtoImpl() {}
	
	public SearchRequestDtoImpl(String sido, String category, String keyword) {
		super();
		this.sido = sido;
		this.category = category;
		this.keyword = keyword;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
