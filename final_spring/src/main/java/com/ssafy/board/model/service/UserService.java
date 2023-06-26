package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserService {

	// 사용자 전체 조회
	List<User> getUserList();

	// 로그인
	User login(String userId, String userPwd);

	// 회원가입
	void signup(User user);

	// 아이디 중복검사
	boolean isIdExist(String id);

	// 닉네임 중복검사
	boolean isNicknameExist(String nickname);

	// 이메일 중복검사
	boolean isEmailExist(String email);

	// 좋아요에 따른 유저포인트 증가
	void plusPoint(String userNickname);

	// 좋아요 취소에 따른 유저포인트 감소
	void minusPoint(String userNickname);

}
