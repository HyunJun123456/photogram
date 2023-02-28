package com.cos.photogramstart.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.service.ImageService;
import com.cos.photogramstart.web.dto.image.ImageUploadDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ImageController {
	
	private final ImageService imageService;
	@GetMapping({"/", "/image/story"})
	public String story() {
		return "image/story";
	}
	@GetMapping("/image/popular")
	public String popular() {
		return "image/popular";
	}
	@GetMapping("/image/upload")
	public String upload() {
		return "image/upload";
	}
	
	@PostMapping("/image")
	public String imageUpload(ImageUploadDto imageUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		// 서비스 호출
		imageService.사진업로드(imageUploadDto, principalDetails); // 컨트롤러의 역할: 사용자로부터 데이터를 받고 서비스를 호출하는 일을 하면 됨
		return "redirect:/user/"+principalDetails.getUser().getId();
	}
	
}
