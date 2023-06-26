package com.ssafy.board.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;
import com.ssafy.board.util.JwtUtil;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/userapi")
@Api(tags = "User-API")
//@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	JwtUtil jwtUtil;

	private static final String SUCCESS = "succes";
	private static final String FAIL = "fail";

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<User> signup(User user) {
		userService.signup(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	// 로그아웃
//    @DeleteMapping("/logout")
//    public ResponseEntity<Void> logout(HttpServletRequest request) {
//        String token = request.getHeader("access-token");
//
//        try {
//            // 토큰 유효성 검사
//            jwtUtil.valid(token);
//            
//            // 로그아웃 처리
//            // 클라이언트의 토큰을 무효화하거나 저장된 토큰을 삭제하는 등의 작업 수행
//            
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            // 유효하지 않은 토큰 처리
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }

	@PostMapping("/login")
	public ResponseEntity<?> login(User user) {

		User loginUser = userService.login(user.getUserId(), user.getUserPwd());
		HttpStatus status = null;

		Map<String, Object> result = new HashMap<String, Object>();

		// 로그인 유저가 존재할 때
		if (loginUser != null) {
			Map<String, Object> claims = new HashMap<>();
			claims.put("nickname", loginUser.getUserNickname());
			claims.put("points", loginUser.getUserPoint());

			try {
				result.put("access-token", jwtUtil.createToken("data", claims));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (UnsupportedEncodingException e) {
				result.put("message", FAIL);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			return new ResponseEntity<Map<String, Object>>(result, status);
		}

		// 로그인 유저가 존재하지 않을 때
		result.put("message", FAIL);
		status = HttpStatus.NO_CONTENT;
		return new ResponseEntity<Void>(status);
	}

	// 모든 회원정보 가져오기
	@GetMapping("/user")
	public ResponseEntity<?> getUserList() {
		List<User> userList = userService.getUserList();

		if (userList != null && userList.size() > 0) {
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		}

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	// 아이디 중복 확인
	@PostMapping("/checkId/{userId}")
	public ResponseEntity<Boolean> checkId(@PathVariable String userId) {
		boolean isExist = userService.isIdExist(userId);
		return new ResponseEntity<Boolean>(isExist, HttpStatus.OK);
	}

	// 닉네임 중복 확인
	@PostMapping("/checkNickname/{nickname}")
	public ResponseEntity<Boolean> checkNickname(@PathVariable String nickname) {
		boolean isExist = userService.isNicknameExist(nickname);
		return ResponseEntity.ok(isExist);
	}

	// 이메일 중복 확인
	@PostMapping("/checkEmail/{email}")
	public ResponseEntity<Boolean> checkEmail(@PathVariable String email) {
		boolean isExist = userService.isEmailExist(email);
		return ResponseEntity.ok(isExist);
	}

	// 좋아요 > 포인트 증가
	@GetMapping("/plusPoint/{userNickname}")
	public ResponseEntity<Void> plusPoint(@PathVariable String userNickname) {
		userService.plusPoint(userNickname);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	// 좋아요 취소 > 포인트 감소
	@GetMapping("/minusPoint/{userNickname}")
	public ResponseEntity<Void> minusPoint(@PathVariable String userNickname) {
		userService.minusPoint(userNickname);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
