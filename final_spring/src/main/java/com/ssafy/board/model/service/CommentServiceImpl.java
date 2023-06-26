package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.CommentDao;
import com.ssafy.board.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	private CommentDao commentDao;

	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	@Override
	public List<Comment> getCommentList(int boardId) {
		return commentDao.selectAllComments(boardId);
	}

	@Override
	public void writeComment(Comment comment) {
		commentDao.insertComment(comment);
	}

	@Override
	public int removeComment(int commentId) {
		return commentDao.deleteComment(commentId);
	}

	@Override
	public int modifyComment(Comment comment) {
		return commentDao.updateComment(comment);
	}

}
