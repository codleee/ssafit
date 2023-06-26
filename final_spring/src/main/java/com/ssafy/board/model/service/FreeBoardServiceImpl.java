package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.FreeBoardDao;
import com.ssafy.board.model.dto.FreeBoard;
import com.ssafy.board.model.dto.SearchCondition;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Autowired
	private FreeBoardDao freeBoardDao;


	@Override
	public FreeBoard getBoardById(int boardId) {
		return freeBoardDao.selectByBoardId(boardId);
	}

	@Override
	public void registBoard(FreeBoard freeBoard) {
		freeBoardDao.insertBoard(freeBoard);
	}

	@Override
	public int updateBoard(FreeBoard freeBoard) {
		return freeBoardDao.updateBoard(freeBoard);
	}

	@Override
	public int deleteBoard(int boardId) {
		return freeBoardDao.deleteBoard(boardId);
	}

	@Override
	public List<FreeBoard> search(SearchCondition searchCondition) {
		return freeBoardDao.searchBoard(searchCondition);
	}

	@Override
	public void plusLike(int boardId) {
		freeBoardDao.plusLike(boardId);
	}

	@Override
	public void minusLike(int boardId) {
		freeBoardDao.minusLike(boardId);
		
	}

}
