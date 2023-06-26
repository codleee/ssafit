package com.ssafy.board.model.dao;

import com.ssafy.board.model.dto.FreeLike;

public interface FreeLikeDao {

	void addFreeLike(FreeLike freeLike);

	void deleteFreeLike(FreeLike freeLike);

	FreeLike selectFreeLike(FreeLike freeLike);
}
