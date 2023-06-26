package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		return userDao.selectAllUsers();
	}

	@Override
	public User login(String userId, String userPwd) {
		User user = userDao.selectByUserId(userId);

		if (user != null && user.getUserPwd().equals(userPwd)) {
			return user;
		}

		return null;
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

	// 입력된 id를 가진 유저가 있는지 확인
	@Override
	public boolean isIdExist(String userId) {
		User user = userDao.selectByUserId(userId);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isNicknameExist(String userNickname) {
		User user = userDao.selectByUserNickname(userNickname);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmailExist(String userEmail) {
		User user = userDao.selectByUserEmail(userEmail);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public void plusPoint(String userNickname) {
		userDao.plusPoint(userNickname);
	}

	@Override
	public void minusPoint(String userNickname) {
		userDao.minusPoint(userNickname);
	}

}
