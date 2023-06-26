package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.TefBoard;

public interface TefBoardService {

	// id로 특정 게시물 찾기
	TefBoard getBoardById(int boardId);

	// 게시물 등록
	void registBoard(TefBoard tefBoard);

	// 게시물 수정
	int updateBoard(TefBoard tefBoard);

	// 게시물 삭제
	int deleteBoard(int boardId);

	// 검색
	List<TefBoard> search(SearchCondition searchCondition);

	// 좋아요 추가
	void plusLike(int boardId);

	// 좋아요 취소
	void minusLike(int boardId);
}
