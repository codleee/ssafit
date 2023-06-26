package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.FreeLikeDao;
import com.ssafy.board.model.dto.FreeLike;

@Service
public class FreeLikeServiceImpl implements FreeLikeService {

	@Autowired
	private FreeLikeDao freeLikeDao;

	@Override
	public void addFreeLike(FreeLike freeLike) {
		freeLikeDao.addFreeLike(freeLike);
	}

	@Override
	public void deleteFreeLike(FreeLike freeLike) {
		freeLikeDao.deleteFreeLike(freeLike);

	}

	@Override
	public FreeLike selectFreeLike(FreeLike freeLike) {
		return freeLikeDao.selectFreeLike(freeLike);
	}

}
