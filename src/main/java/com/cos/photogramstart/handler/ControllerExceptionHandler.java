package com.cos.photogramstart.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomApiException;
import com.cos.photogramstart.handler.ex.CustomException;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.util.Script;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice // 모든 Exception을 낚아챔
public class ControllerExceptionHandler {
	
	@ExceptionHandler(CustomValidationException.class)
	public String validationException(CustomValidationException e) { // ? 적으면 추론함
		// CMRespDto, Script 비교
		// 1. 클라이언트에게 응답할 때는 Script 좋음.
		// 2. Ajax 통신 - CMRespDto
		// 3. Android통신 - CMRespDto
		if(e.getErrorMap() == null) {
			return Script.back(e.getMessage());
		}else {
			return Script.back(e.getErrorMap().toString());			
		}
	}
	
	@ExceptionHandler(CustomValidationApiException.class)
	public ResponseEntity<?> validationApiException(CustomValidationApiException e) { // ? 적으면 추론함
		// ResponseEntity를 사용하면 상태코드를 던져줄 수 있어 ajax 활용시 유용
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomApiException.class)
	public ResponseEntity<?> apiException(CustomApiException e) { // ? 적으면 추론함
		// ResponseEntity를 사용하면 상태코드를 던져줄 수 있어 ajax 활용시 유용
		return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(CustomException.class)
	public String exception(CustomException e) { 
		return Script.back(e.getMessage());
	}
	
	
}
