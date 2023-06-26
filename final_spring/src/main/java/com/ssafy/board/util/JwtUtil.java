package com.ssafy.board.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	private static final String SALT = "SSAFIT";

	// 토큰 생성
	// 인자로 키와 벨류가 넘어왔다라고만 처리 (한가지의 정보만 넣는다고 가정)
	// 우리는 유저의 닉네임만 넣어주면 될듯
	// 로그인의 목적: 1. 상단에 {userNickname}님 반갑습니다 2. 로그인한 유저만 게시물 등록 가능 2-1. 그 중 본인의 아이디와
	// 같은 경우에만 수정, 삭제 가능 3. 댓글 관련 기능
	public String createToken(String claimId, Map<String, Object> claims) throws UnsupportedEncodingException {
		// 테스트하는데 잠시 방해가되는 유효기간은 지운다..
		return Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT") // 헤더완료
				.claim(claimId, claims).signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // 서명완료
				.compact();
	}

	// 유효성 검사
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey("SSAFIT".getBytes("UTF-8")).parseClaimsJws(token);
	}
}