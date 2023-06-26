package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.TefBoardDao;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.TefBoard;

@Service
public class TefBoardServiceImpl implements TefBoardService {

	@Autowired
	private TefBoardDao tefBoardDao;

	@Override
	public TefBoard getBoardById(int boardId) {
		return tefBoardDao.selectByBoardId(boardId);
	}

	@Override
	public void registBoard(TefBoard tefBoard) {
		tefBoardDao.insertBoard(tefBoard);
	}

	@Override
	public int updateBoard(TefBoard tefBoard) {
		return tefBoardDao.updateBoard(tefBoard);
	}

	@Override
	public int deleteBoard(int boardId) {
		return tefBoardDao.deleteBoard(boardId);
	}

	@Override
	public List<TefBoard> search(SearchCondition searchCondition) {
		return tefBoardDao.searchBoard(searchCondition);
	}

	@Override
	public void plusLike(int boardId) {
		tefBoardDao.plusLike(boardId);
	}

	@Override
	public void minusLike(int boardId) {
		tefBoardDao.minusLike(boardId);
	}

}
