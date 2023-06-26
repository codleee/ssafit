package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Comment;

public interface CommentService {
	// 댓글 전체 조회
	List<Comment> getCommentList(int boardId);

	// 댓글 작성
	void writeComment(Comment comment);

	// 댓글 삭제
	int removeComment(int commentId);

	// 댓글 수정
	int modifyComment(Comment comment);

}
