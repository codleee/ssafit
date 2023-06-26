package com.ssafy.board.model.dto;

import java.util.Date;

public class Comment {
	private int commentId; // 댓글 번호
	private int boardId; // 게시물 번호
	private String commentWriter; // 댓글 작성자
	private String commentContent; // 댓글 내용
	private Date commentCreatedAt; // 댓글 등록일
	private Date commentUpdatedAt; // 댓글 수정일

	// 기본 생성자.
	public Comment() {
	}

	// 파라미터를 받는 생성자.
	public Comment(int commentId, int boardId, String commentWriter, String commentContent,
			Date commentCreatedAt, Date commentUpdatedAt) {
		this.commentId = commentId;
		this.boardId = boardId;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
		this.commentCreatedAt = commentCreatedAt;
		this.commentUpdatedAt = commentUpdatedAt;
	}

	// getter & setter.
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentCreatedAt() {
		return commentCreatedAt;
	}

	public void setCommentCreatedAt(Date commentCreatedAt) {
		this.commentCreatedAt = commentCreatedAt;
	}

	public Date getCommentUpdatedAt() {
		return commentUpdatedAt;
	}

	public void setCommentUpdatedAt(Date commentUpdatedAt) {
		this.commentUpdatedAt = commentUpdatedAt;
	}

}
