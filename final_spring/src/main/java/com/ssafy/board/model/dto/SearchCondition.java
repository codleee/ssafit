package com.ssafy.board.model.dto;

public class SearchCondition {
	private String key = "none"; // 검색 조건
	private String value; // 검색 값
	private String orderBy = "none"; // 정렬 조건
	private String orderByDir; // 정렬 방향

	// 기본 생성자.
	public SearchCondition() {
		super();
	}

	// getter & setter.
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

}
