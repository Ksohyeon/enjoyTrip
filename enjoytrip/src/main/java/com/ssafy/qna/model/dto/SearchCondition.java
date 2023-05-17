package com.ssafy.qna.model.dto;

public class SearchCondition {
	
	// 한 페이지에 몇개를 보여줄 것인지 결정
	public final int countPerPage = 10;
	
	// 검색 컬럼명
	private String key = "none";  // none은 컬럼이 없는 경우
	
	// 검색어
	private String word;
	
	// 검색 결과를 정렬할 컬럼명
	private String orderBy = "none";
	
	// 정렬 방향
	private String orderByDir = "asc";
	
	// 현재 페이지 번호 (offset을 계산)
	private int currentPage = 1;  // 기본 페이지 1
	
	// limit을 적용할 것인지 설정
	private boolean limit = true;
	
	// 사용 편의를 위해 여러 생성자 작성
	public SearchCondition() {}

	public SearchCondition(String key, String word, String orderBy, String orderByDir, int currentPage) {
		this.key = key;
		this.word = word;
		this.orderBy = orderBy;
		this.orderByDir = orderByDir;
		this.currentPage = currentPage;
	}
	
	public SearchCondition(String key, String word, String orderBy, String orderByDir) {
		this(key, word, orderBy, orderByDir, 1);
	}
	
	public SearchCondition(String key, String word, String orderBy) {
		this(key, word, orderBy, "asc");
	}
	
	public SearchCondition(String key, String word) {
		this(key, word, "none");
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderByDir() {
		return orderByDir;
	}

	public void setOrderByDir(String orderByDir) {
		this.orderByDir = orderByDir;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isLimit() {
		return limit;
	}

	public void setLimit(boolean limit) {
		this.limit = limit;
	}

	public int getCountPerPage() {
		return countPerPage;
	}
	
	/*
	 * limit의 offset을 구한다.
	 * 페이징으로 일부분만을 가져올 때 페이지의 시작 정보 위치로 메서드에 의해 계산된다.
	 * 전달된 currentPage는 1부터 시작하고 데이터베이는 0부터 시작이므로 1을 빼준다.
	 */
	public int getOffset() {
		return (this.currentPage - 1) * countPerPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchCondition [countPerPage=");
		builder.append(countPerPage);
		builder.append(", key=");
		builder.append(key);
		builder.append(", word=");
		builder.append(word);
		builder.append(", orderBy=");
		builder.append(orderBy);
		builder.append(", orderByDir=");
		builder.append(orderByDir);
		builder.append(", currentPage=");
		builder.append(currentPage);
		builder.append(", limit=");
		builder.append(limit);
		builder.append("]");
		return builder.toString();
	}
	
}
