package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.FreeLike;
import com.ssafy.board.model.dto.TefLike;
import com.ssafy.board.model.service.FreeLikeService;
import com.ssafy.board.model.service.TefLikeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/likeapi")
@Api(tags = "Like-API")
public class LikeRestController {

	@Autowired
	private FreeLikeService fls;
	@Autowired
	private TefLikeService tls;

	// 자유게시판

	// 1. 좋아요 정보를 DB에 넣어주자
	@GetMapping("/free/add")
	public ResponseEntity<Void> addFreeLike(FreeLike freeLike) {
		fls.addFreeLike(freeLike);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 2. 좋아요 정보를 DB에서 삭제하자
	@GetMapping("/free/delete")
	public ResponseEntity<Void> deleteFreeLike(FreeLike freeLike) {
		fls.deleteFreeLike(freeLike);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 3. 특정 게시물로 이동했을 때, 해당 유저가 게시물에 좋아요를 눌렀었는지 확인해주자
	// 있으면 true 없으면 false 반환
	@GetMapping("/free/check")
	public boolean checkFreeLike(FreeLike freeLike) {
		FreeLike fLike = fls.selectFreeLike(freeLike);

		if (fLike != null) {
			return true;
		}

		return false;

	}

	// 오운완게시판

	// 1. 좋아요 정보를 DB에 넣어주자
	@GetMapping("/tef/add")
	public ResponseEntity<Void> addTefLike(TefLike tefLike) {
		tls.addTefLike(tefLike);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 2. 좋아요 정보를 DB에서 삭제하자
	@GetMapping("/tef/delete")
	public ResponseEntity<Void> deleteTefLike(TefLike tefLike) {
		tls.deleteTefLike(tefLike);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 3. 특정 게시물로 이동했을 때, 해당 유저가 게시물에 좋아요를 눌렀었는지 확인해주자
	// 있으면 true 없으면 false 반환
	@GetMapping("/tef/check")
	public boolean checkTefLike(TefLike tefLike) {
		TefLike tLike = tls.selectTefLike(tefLike);

		if (tLike != null) {
			return true;
		}

		return false;
	}

}
