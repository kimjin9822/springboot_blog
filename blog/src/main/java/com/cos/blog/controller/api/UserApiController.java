package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;

	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출됨"); // DB에 insert를 하고 return
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환후 리턴 (Jackson)
	}
	
	@PutMapping("/user")
		public ResponseDto<Integer> update(@RequestBody User user){
			userService.회원수정(user);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
