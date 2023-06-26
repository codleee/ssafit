package com.ssafy.board.model.dao;

import com.ssafy.board.model.dto.TefLike;

public interface TefLikeDao {

	void addTefLike(TefLike tefLike);

	void deleteTefLike(TefLike tefLike);

	TefLike selectTefLike(TefLike tefLike);
}
