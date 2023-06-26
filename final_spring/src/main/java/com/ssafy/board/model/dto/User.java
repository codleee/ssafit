package com.ssafy.board.model.dto;

public class User {
	private int userSeq; // 사용자 번호
	private String userId; // 사용자 아이디
	private String userPwd; // 사용자 비밀번호
	private String userName; // 사용자 이름
	private String userNickname; // 사용자 닉네임
	private String userEmail; // 사용자 이메일
	private int userPoint; // 사용자 포인트

	// 기본 생성자
	public User() {
	}

	// 파라미터를 받는 생성자.
	public User(int userSeq, String userId, String userPwd, String userName, String userNickname, String userEmail,
			int userPoint) {
		this.userSeq = userSeq;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userPoint = userPoint;
	}

	// getter & setter.
	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

}
