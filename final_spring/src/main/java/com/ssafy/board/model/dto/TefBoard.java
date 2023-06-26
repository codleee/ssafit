package com.ssafy.board.model.dto;

import java.util.Date;

public class TefBoard {
	private int tefBoardId; // 게시물 번호
	private String tefBoardImg; // 게시물 이미지
	private String tefBoardTitle; // 게시물 제목
	private String tefBoardContent; // 게시물 내용
	private String tefBoardWriter; // 게시물 작성자
	private Date tefBoardCreatedAt; // 게시물 등록일
	private Date tefBoardUpdatedAt; // 게시물 수정일
	private int tefBoardLike; // 게시물 좋아요 수

	public TefBoard() {
		// TODO Auto-generated constructor stub
	}

	public TefBoard(int tefBoardId, String tefBoardImg, String tefBoardTitle, String tefBoardContent,
			String tefBoardWriter, Date tefBoardCreatedAt, Date tefBoardUpdatedAt, int tefBoardLike) {
		this.tefBoardId = tefBoardId;
		this.tefBoardImg = tefBoardImg;
		this.tefBoardTitle = tefBoardTitle;
		this.tefBoardContent = tefBoardContent;
		this.tefBoardWriter = tefBoardWriter;
		this.tefBoardCreatedAt = tefBoardCreatedAt;
		this.tefBoardUpdatedAt = tefBoardUpdatedAt;
		this.tefBoardLike = tefBoardLike;
	}

	public int getTefBoardId() {
		return tefBoardId;
	}

	public void setTefBoardId(int tefBoardId) {
		this.tefBoardId = tefBoardId;
	}

	public String getTefBoardImg() {
		return tefBoardImg;
	}

	public void setTefBoardImg(String tefBoardImg) {
		this.tefBoardImg = tefBoardImg;
	}

	public String getTefBoardTitle() {
		return tefBoardTitle;
	}

	public void setTefBoardTitle(String tefBoardTitle) {
		this.tefBoardTitle = tefBoardTitle;
	}

	public String getTefBoardContent() {
		return tefBoardContent;
	}

	public void setTefBoardContent(String tefBoardContent) {
		this.tefBoardContent = tefBoardContent;
	}

	public String getTefBoardWriter() {
		return tefBoardWriter;
	}

	public void setTefBoardWriter(String tefBoardWriter) {
		this.tefBoardWriter = tefBoardWriter;
	}

	public Date getTefBoardCreatedAt() {
		return tefBoardCreatedAt;
	}

	public void setTefBoardCreatedAt(Date tefBoardCreatedAt) {
		this.tefBoardCreatedAt = tefBoardCreatedAt;
	}

	public Date getTefBoardUpdatedAt() {
		return tefBoardUpdatedAt;
	}

	public void setTefBoardUpdatedAt(Date tefBoardUpdatedAt) {
		this.tefBoardUpdatedAt = tefBoardUpdatedAt;
	}

	public int getTefBoardLike() {
		return tefBoardLike;
	}

	public void setTefBoardLike(int tefBoardLike) {
		this.tefBoardLike = tefBoardLike;
	}

	@Override
	public String toString() {
		return "TefBoard [tefBoardId=" + tefBoardId + ", tefBoardImg=" + tefBoardImg + ", tefBoardTitle="
				+ tefBoardTitle + ", tefBoardContent=" + tefBoardContent + ", tefBoardWriter=" + tefBoardWriter
				+ ", tefBoardCreatedAt=" + tefBoardCreatedAt + ", tefBoardUpdatedAt=" + tefBoardUpdatedAt
				+ ", tefBoardLike=" + tefBoardLike + "]";
	}

}
