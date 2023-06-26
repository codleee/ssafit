package com.ssafy.board.model.dao;

import java.util.List;


import com.ssafy.board.model.dto.EventBoard;
import com.ssafy.board.model.dto.SearchCondition;

public interface EventBoardDao {


	// 특정 게시물을 선택한다.
	EventBoard selectByBoardId(int boardId);

	// 게시물 검색 및 정렬하기.
	List<EventBoard> searchBoard(SearchCondition searchCondition);

}
