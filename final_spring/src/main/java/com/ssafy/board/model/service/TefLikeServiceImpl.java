package com.ssafy.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.TefLikeDao;
import com.ssafy.board.model.dto.TefLike;

@Service
public class TefLikeServiceImpl implements TefLikeService {

	@Autowired
	private TefLikeDao tefLikeDao;

	@Override
	public void addTefLike(TefLike tefLike) {
		tefLikeDao.addTefLike(tefLike);
	}

	@Override
	public void deleteTefLike(TefLike tefLike) {
		tefLikeDao.deleteTefLike(tefLike);

	}

	@Override
	public TefLike selectTefLike(TefLike tefLike) {
		return tefLikeDao.selectTefLike(tefLike);
	}

}
