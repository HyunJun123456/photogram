package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.web.dto.auth.SignupDto;

@Controller // 1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	// 회원가입버튼 -> /auth/signup -> /auth/signin
	// 회원가입버튼 X -> csrf 토큰이 활성화 되어 있어서
	/* 클라이언트가 데이터를 담아 버튼을 눌러 데이터를 전송할 때 
	시큐리티 CSRF 토큰을 검사하게 됨
	input 태그에 임시 토큰값이 생기게 됨
	정상적인 사용자인지 비정상적인 사용인지 구분하기 위해서*/
	@PostMapping("/auth/signup")
	public String signup(SignupDto signupDto) { // key=value (x-www-form-urlencoded)
		log.info(signupDto.toString());
		return "auth/signin"; // 회원가입 성공시
	}
	
}
