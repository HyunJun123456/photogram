package com.cos.photogramstart.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.photogramstart.config.auth.PrincipalDetails;

@Controller
public class UserController {
	@GetMapping("/user/{id}")
	public String profile(@PathVariable int id) {
		return "user/profile";
	}
	
	@GetMapping("/user/{id}/update")
	public String update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) { // 그래서 어노테이션을 만들어줌
		// session -> securityContextholder -> Authentication -> PrincipalDetails(UserDetails)
		System.out.println("세션 정보: "+principalDetails.getUser());
		/*
		 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 * PrincipalDetails mPrincipalDetails = (PrincipalDetails) auth.getPrincipal();
		 * System.out.println("직접 찾은 세션 정보: "+mPrincipalDetails.getUser());
		 */
		//model.addAttribute("principal", principalDetails.getUser());
		return "user/update";
	}
	
}
