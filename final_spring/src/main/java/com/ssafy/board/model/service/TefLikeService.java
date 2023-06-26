package com.ssafy.board.model.service;

import com.ssafy.board.model.dto.TefLike;

public interface TefLikeService {

	void addTefLike(TefLike tefLike);

	void deleteTefLike(TefLike tefLike);

	TefLike selectTefLike(TefLike tefLike);

}
