package com.cos.photogramstart.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.user.UserProfileDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/user/{pageUserId}")
	public String profile(@PathVariable int pageUserId, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		UserProfileDto dto = userService.회원프로필(pageUserId, principalDetails.getUser().getId());
		model.addAttribute("dto", dto);
		return "user/profile";
	}
	
	@GetMapping("/user/{id}/update")
	public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) { // 그래서 어노테이션을 만들어줌
		// session -> securityContextholder -> Authentication -> PrincipalDetails(UserDetails)
		//System.out.println("세션 정보: "+principalDetails.getUser());
		/*
		 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 * PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();
		 * System.out.println("직접 찾은 세션 정보: "+mPrincipalDetails.getUser());
		 */
		//model.addAttribute("principal", principalDetails.getUser());
		return "user/update";
	}
	
}
/*
 * 1. fk는 Many가 가진다.
 * 2. N : N의 관계는 중간 테이블이 생긴다.
 * 
 * AOP 처리
 * Aspect Orientied Programming 관점 지향 프로그램
 * 
 * */
