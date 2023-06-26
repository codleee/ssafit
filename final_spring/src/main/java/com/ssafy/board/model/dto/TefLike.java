package com.ssafy.board.model.dto;

public class TefLike {
	// 오운완 게시물의 좋아요 현황을 담아줄 DTO
	private int tefLikeId;
	private int tefBoardId;
	private String userNickname;

	public int getTefLikeId() {
		return tefLikeId;
	}

	public void setTefLikeId(int tefLikeId) {
		this.tefLikeId = tefLikeId;
	}

	public int getTefBoardId() {
		return tefBoardId;
	}

	public void setTefBoardId(int tefBoardId) {
		this.tefBoardId = tefBoardId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

}
