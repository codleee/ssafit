package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.EventBoard;
import com.ssafy.board.model.dto.SearchCondition;

public interface EventBoardService {


	// id로 특정 게시물 찾기
	EventBoard getBoardById(int boardId);

	// 검색
	List<EventBoard> search(SearchCondition searchCondition);

}
