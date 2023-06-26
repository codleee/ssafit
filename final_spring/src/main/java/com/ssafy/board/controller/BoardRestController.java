package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.EventBoard;
import com.ssafy.board.model.dto.FreeBoard;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.TefBoard;
import com.ssafy.board.model.service.EventBoardService;
import com.ssafy.board.model.service.FreeBoardService;
import com.ssafy.board.model.service.TefBoardService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/boardapi")
@Api(tags = "Board-API")
public class BoardRestController {

	@Autowired
	private EventBoardService ebs;
	@Autowired
	private FreeBoardService fbs;
	@Autowired
	private TefBoardService tbs;

	// 이벤트 게시판
	// 1. 게시물 목록 가져오기
	// 검색 사항이 있을 시에는 해당 결과에 맞는 게시물만 가져옴
	// 검색 사항이 아무것도 없을 시에는 전체 게시물을 갖고 오겠네
	// => 검색기능을 따로 구현할 필요가 없음
	@GetMapping("/event")
	public ResponseEntity<?> getEventList(SearchCondition searchCondition) {
		List<EventBoard> eventList = ebs.search(searchCondition);

		// List가 null이 아니고, 안에 요소가 들었다면 상태코드와 함께 반환
		if (eventList != null && eventList.size() > 0) {
			return new ResponseEntity<List<EventBoard>>(eventList, HttpStatus.OK);
		}

		// 아니라면 상태코드만 반환
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// 2. id로 특정 게시물 찾기
	@GetMapping("/event/{boardId}")
	public ResponseEntity<?> getEventById(@PathVariable int boardId) {
		EventBoard eventBoard = ebs.getBoardById(boardId);

		// 게시물이 존재한다면 상태코드와 함께 반환
		if (eventBoard != null) {
			return new ResponseEntity<EventBoard>(eventBoard, HttpStatus.OK);
		}

		// 아니라면 상태코드만 반환
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// 자유 게시판
	// 1.게시물 목록 가져오기
	@GetMapping("/free")
	public ResponseEntity<?> getFreeList(SearchCondition searchCondition) {
		List<FreeBoard> freeList = fbs.search(searchCondition);

		// List가 null이 아니고, 안에 요소가 들었다면 상태코드와 함께 반환
		if (freeList != null && freeList.size() > 0) {
			return new ResponseEntity<List<FreeBoard>>(freeList, HttpStatus.OK);
		}

		// 아니라면 상태코드만 반환
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// 2. id로 특정 게시물 찾기
	@GetMapping("/free/{id}")
	public ResponseEntity<?> getFreeById(@PathVariable int id) {
		FreeBoard freeBoard = fbs.getBoardById(id);

		// 게시물이 존재한다면 상태코드와 함께 반환
		if (freeBoard != null) {
			return new ResponseEntity<FreeBoard>(freeBoard, HttpStatus.OK);
		}

		// 아니라면 상태코드만 반환
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// 3. 게시물 등록
	@PostMapping("free/regist")
	public ResponseEntity<Integer> registBoard(FreeBoard fb) {
		fbs.registBoard(fb);
		return new ResponseEntity<Integer>(fb.getFreeBoardId(), HttpStatus.OK);
	}

	// 4. 게시물 수정
	@PutMapping("free/update")
	public ResponseEntity<Void> updateBoard(FreeBoard fb) {
		int result = fbs.updateBoard(fb);

		// 게시물이 성공적으로 수정되었다면 1이 반환되었을 것이다
		if (result == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		// 아니라면 수정되지 못했다는 상태코드를 보내주자
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}

	// 5. 게시물 삭제
	@DeleteMapping("free/delete/{id}")
	public ResponseEntity<Void> deleteFreeBoard(@PathVariable int id) {
		int result = fbs.deleteBoard(id);

		// 게시물이 성공적으로 삭제되었다면 1이 반환되었을 것이다
		if (result == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		// 아니라면 삭제되지 못했다는 상태코드를 보내주자
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}

	// 6. 게시물 좋아요
	@GetMapping("free/plus/{id}")
	public ResponseEntity<Void> plusFreeLike(@PathVariable int id) {
		fbs.plusLike(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 7. 게시물 좋아요 취소
	@GetMapping("free/minus/{id}")
	public ResponseEntity<Void> minusFreeLike(@PathVariable int id) {
		fbs.minusLike(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 오운완 게시판

	// 1.게시물 목록 가져오기
	@GetMapping("/tef")
	public ResponseEntity<?> getTefList(SearchCondition searchCondition) {
		List<TefBoard> tefList = tbs.search(searchCondition);

		// List가 null이 아니고, 안에 요소가 들었다면 상태코드와 함께 반환
		if (tefList != null && tefList.size() > 0) {
			return new ResponseEntity<List<TefBoard>>(tefList, HttpStatus.OK);
		}

		// 아니라면 상태코드만 반환
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// 2. id로 특정 게시물 찾기
	@GetMapping("/tef/{id}")
	public ResponseEntity<?> getTefById(@PathVariable int id) {
		TefBoard tefBoard = tbs.getBoardById(id);

		// 게시물이 존재한다면 상태코드와 함께 반환
		if (tefBoard != null) {
			return new ResponseEntity<TefBoard>(tefBoard, HttpStatus.OK);
		}

		// 아니라면 상태코드만 반환
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// resource의 경로를 가져오기 위해서 사용
	@Autowired
	private ResourceLoader resLoader;

	// 3. 게시물 등록
	@PostMapping("tef/regist")
	public ResponseEntity<Integer> registBoard(TefBoard tb) throws IOException {
		System.out.println(tb.toString());
		tbs.registBoard(tb);
		return new ResponseEntity<Integer>(tb.getTefBoardId(), HttpStatus.OK);
	}

	// 4. 게시물 수정
	@PutMapping("tef/update")
	public ResponseEntity<Void> updateBoard(TefBoard tb) {
		int result = tbs.updateBoard(tb);

		// 게시물이 성공적으로 수정되었다면 1이 반환되었을 것이다
		if (result == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		// 아니라면 수정되지 못했다는 상태코드를 보내주자
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}

	// 5. 게시물 삭제
	@DeleteMapping("tef/delete/{id}")
	public ResponseEntity<Void> deleteTefBoard(@PathVariable int id) {
		int result = tbs.deleteBoard(id);

		// 게시물이 성공적으로 삭제되었다면 1이 반환되었을 것이다
		if (result == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		// 아니라면 삭제되지 못했다는 상태코드를 보내주자
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}

	// 6. 게시물 좋아요
	@GetMapping("tef/plus/{id}")
	public ResponseEntity<Void> plusTefLike(@PathVariable int id) {
		tbs.plusLike(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 7. 게시물 좋아요 취소
	@GetMapping("tef/minus/{id}")
	public ResponseEntity<Void> minusTefLike(@PathVariable int id) {
		tbs.minusLike(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
