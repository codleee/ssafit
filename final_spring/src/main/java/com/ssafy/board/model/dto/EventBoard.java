package com.ssafy.board.model.dto;

import java.util.Date;

public class EventBoard {
	private int eventBoardId; // 게시물 번호
	private String eventBoardTitle; // 게시물 제목
	private String eventBoardContent; // 게시물 내용
	private String eventBoardWriter; // 게시물 작성자
	private Date eventBoardCreatedAt; // 게시물 등록일
	private Date eventBoardUpdatedAt; // 게시물 수정일

	public EventBoard() {
		// TODO Auto-generated constructor stub
	}

	public EventBoard(int eventBoardId, String eventBoardTitle, String eventBoardContent, String eventBoardWriter,
			Date eventBoardCreatedAt, Date eventBoardUpdatedAt) {
		this.eventBoardId = eventBoardId;
		this.eventBoardTitle = eventBoardTitle;
		this.eventBoardContent = eventBoardContent;
		this.eventBoardWriter = eventBoardWriter;
		this.eventBoardCreatedAt = eventBoardCreatedAt;
		this.eventBoardUpdatedAt = eventBoardUpdatedAt;
	}

	public int getEventBoardId() {
		return eventBoardId;
	}

	public void setEventBoardId(int eventBoardId) {
		this.eventBoardId = eventBoardId;
	}

	public String getEventBoardTitle() {
		return eventBoardTitle;
	}

	public void setEventBoardTitle(String eventBoardTitle) {
		this.eventBoardTitle = eventBoardTitle;
	}

	public String getEventBoardContent() {
		return eventBoardContent;
	}

	public void setEventBoardContent(String eventBoardContent) {
		this.eventBoardContent = eventBoardContent;
	}

	public String getEventBoardWriter() {
		return eventBoardWriter;
	}

	public void setEventBoardWriter(String eventBoardWriter) {
		this.eventBoardWriter = eventBoardWriter;
	}

	public Date getEventBoardCreatedAt() {
		return eventBoardCreatedAt;
	}

	public void setEventBoardCreatedAt(Date eventBoardCreatedAt) {
		this.eventBoardCreatedAt = eventBoardCreatedAt;
	}

	public Date getEventBoardUpdatedAt() {
		return eventBoardUpdatedAt;
	}

	public void setEventBoardUpdatedAt(Date eventBoardUpdatedAt) {
		this.eventBoardUpdatedAt = eventBoardUpdatedAt;
	}

}
