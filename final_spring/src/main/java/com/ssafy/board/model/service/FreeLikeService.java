package com.ssafy.board.model.service;

import com.ssafy.board.model.dto.FreeLike;

public interface FreeLikeService {

	void addFreeLike(FreeLike freeLike);

	void deleteFreeLike(FreeLike freeLike);

	FreeLike selectFreeLike(FreeLike freeLike);
}
