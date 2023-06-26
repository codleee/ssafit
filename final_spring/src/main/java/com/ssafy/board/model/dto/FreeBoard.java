package com.ssafy.board.model.dto;

import java.util.Date;

public class FreeBoard {
	private int freeBoardId; // 게시물 번호
	private String freeBoardTitle; // 게시물 제목
	private String freeBoardContent; // 게시물 내용
	private String freeBoardWriter; // 게시물 작성자
	private Date freeBoardCreatedAt; // 게시물 등록일
	private Date freeBoardUpdatedAt; // 게시물 수정일
	private int freeBoardLike; // 게시물 좋아요 수

	public FreeBoard() {
		// TODO Auto-generated constructor stub
	}

	public FreeBoard(int freeBoardId, String freeBoardTitle, String freeBoardContent, String freeBoardWriter,
			Date freeBoardCreatedAt, Date freeBoardUpdatedAt, int freeBoardLike) {
		this.freeBoardId = freeBoardId;
		this.freeBoardTitle = freeBoardTitle;
		this.freeBoardContent = freeBoardContent;
		this.freeBoardWriter = freeBoardWriter;
		this.freeBoardCreatedAt = freeBoardCreatedAt;
		this.freeBoardUpdatedAt = freeBoardUpdatedAt;
		this.freeBoardLike = freeBoardLike;
	}

	public int getFreeBoardId() {
		return freeBoardId;
	}

	public void setFreeBoardId(int freeBoardId) {
		this.freeBoardId = freeBoardId;
	}

	public String getFreeBoardTitle() {
		return freeBoardTitle;
	}

	public void setFreeBoardTitle(String freeBoardTitle) {
		this.freeBoardTitle = freeBoardTitle;
	}

	public String getFreeBoardContent() {
		return freeBoardContent;
	}

	public void setFreeBoardContent(String freeBoardContent) {
		this.freeBoardContent = freeBoardContent;
	}

	public String getFreeBoardWriter() {
		return freeBoardWriter;
	}

	public void setFreeBoardWriter(String freeBoardWriter) {
		this.freeBoardWriter = freeBoardWriter;
	}

	public Date getFreeBoardCreatedAt() {
		return freeBoardCreatedAt;
	}

	public void setFreeBoardCreatedAt(Date freeBoardCreatedAt) {
		this.freeBoardCreatedAt = freeBoardCreatedAt;
	}

	public Date getFreeBoardUpdatedAt() {
		return freeBoardUpdatedAt;
	}

	public void setFreeBoardUpdatedAt(Date freeBoardUpdatedAt) {
		this.freeBoardUpdatedAt = freeBoardUpdatedAt;
	}

	public int getFreeBoardLike() {
		return freeBoardLike;
	}

	public void setFreeBoardLike(int freeBoardLike) {
		this.freeBoardLike = freeBoardLike;
	}
}
