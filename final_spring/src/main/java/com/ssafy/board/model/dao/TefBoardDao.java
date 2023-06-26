package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.TefBoard;

public interface TefBoardDao {
	// C
	// 게시물을 작성한다.
	void insertBoard(TefBoard tefBoard);


	// 특정 게시물을 선택한다.
	TefBoard selectByBoardId(int tefBoardId);

	// 게시물 검색 및 정렬하기.
	List<TefBoard> searchBoard(SearchCondition searchCondition);

	// U
	// 게시물을 수정한다.
	int updateBoard(TefBoard tefBoard);

	// D
	// 게시물을 삭제한다.
	int deleteBoard(int tefBoardId);

	// 게시물 좋아요 누르기.
	void plusLike(int tefBoardId);
	
	// 게시물의 좋아요를 한 번 더 누르면 좋아요가 취소됨
	void minusLike(int tefBoardId);
}
