package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Comment;
import com.ssafy.board.model.service.CommentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/commentapi")
@Api(tags = "Comment-API")
//@CrossOrigin("*")
public class CommentRestController {

// 댓글은 자유게시판에서만 작성가능
	@Autowired
	private CommentService cs;

	// 1. 댓글 작성
	@PostMapping("/regist")
	public ResponseEntity<Void> writeComment(Comment comment) {
		cs.writeComment(comment);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 2. 댓글 수정
	@PutMapping("/update")
	public ResponseEntity<Void> updateComment(Comment comment) {
		int result = cs.modifyComment(comment);

		// 댓글이 성공적으로 수정되었다면 1이 반환되었을 것이다
		if (result == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		// 아니라면 수정되지 못했다는 상태코드를 보내주자
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}

	// 3. 댓글 삭제
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable int id) {
		int result = cs.removeComment(id);

		// 댓글이 성공적으로 삭제되었다면 1이 반환되었을 것이다
		if (result == 1) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		// 아니라면 수정되지 못했다는 상태코드를 보내주자
		return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
	}

	// 4. 해당 게시물의 댓글 목록 가져오기
	// 댓글 테이블에는 게시물의 id가 들어감 => 그걸로 특정 게시판의 댓글임을 알 수 있음
	@GetMapping("/comment/{boardId}")
	public ResponseEntity<?> getCommentList(@PathVariable int boardId) {
		List<Comment> commentList = cs.getCommentList(boardId);
		
		if(commentList != null && commentList.size() > 0) {
			return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
