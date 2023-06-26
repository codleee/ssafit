package com.ssafy.board.model.dao;

import java.util.List;

import com.ssafy.board.model.dto.Comment;

public interface CommentDao {
	// CRUD 생성
	// C
	// 댓글을 작성한다.
	void insertComment(Comment comment);

	// 전체 댓글을 선택한다.
	List<Comment> selectAllComments(int boardId);

	// U
	// 댓글을 수정한다.
	int updateComment(Comment comment);

	// D
	// 댓글을 삭제한다.
	int deleteComment(int commentId);
}
