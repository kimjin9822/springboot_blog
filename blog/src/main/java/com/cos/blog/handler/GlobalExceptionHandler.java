package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // Exception 실행시 여기 클래스로 들어오게 해줌
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public String HandleArgumentException(IllegalArgumentException e) {
		return "<h1>"+e.getMessage()+"</h1>";
	}
}
