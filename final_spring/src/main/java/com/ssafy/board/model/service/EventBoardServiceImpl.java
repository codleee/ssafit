package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.EventBoardDao;
import com.ssafy.board.model.dto.EventBoard;
import com.ssafy.board.model.dto.SearchCondition;

@Service
public class EventBoardServiceImpl implements EventBoardService {

	@Autowired
	private EventBoardDao eventBoardDao;

	@Override
	public EventBoard getBoardById(int boardId) {
		return eventBoardDao.selectByBoardId(boardId);
	}

	@Override
	public List<EventBoard> search(SearchCondition searchCondition) {
		return eventBoardDao.searchBoard(searchCondition);
	}

}
