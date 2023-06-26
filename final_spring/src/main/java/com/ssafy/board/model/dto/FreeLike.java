package com.ssafy.board.model.dto;

public class FreeLike {
	// 자유게시판의 게시물의 좋아요 현황을 담아줄 DTO
	private int freeLikeId;
	private int freeBoardId;
	private String userNickname;

	public int getFreeLikeId() {
		return freeLikeId;
	}

	public void setFreeLikeId(int freeLikeId) {
		this.freeLikeId = freeLikeId;
	}

	public int getFreeBoardId() {
		return freeBoardId;
	}

	public void setFreeBoardId(int freeBoardId) {
		this.freeBoardId = freeBoardId;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Override
	public String toString() {
		return "FreeLike [freeLikeId=" + freeLikeId + ", freeBoardId=" + freeBoardId + ", userNickname=" + userNickname
				+ "]";
	}

}
