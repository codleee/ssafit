package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.User;

public interface UserDao {
	// CRUD 생성
	// C
	// 사용자를 추가한다.
	void insertUser(User user);

	// R
	// 사용자를 선택한다.
	User selectByUserId(String userId);

	User selectByUserNickname(String userNickname);

	User selectByUserEmail(String userEmail);

	// 전체 사용자를 선택한다.
	List<User> selectAllUsers();
	
	// 작성자에게 포인트를 더해준다
	void plusPoint(String userNickname);
	
	// 작성자에게 포인트를 빼준다
	void minusPoint(String userNickname);

	// U
	// 사용자 정보를 수정한다.
	// void updateUser(User user);

	// D
	// 사용자 정보를 삭제한다.
	// void deleteUser(String userId);
	// 회원가입

}
