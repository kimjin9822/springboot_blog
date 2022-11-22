package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해 Bean 등록, IOC해줌
public class UserService { // 서비스 필요이유 : 여러개의 트랜잭션 관리,

	@Autowired
	private UserRepository userRepository;

	@Transactional // 전체 트랙잭션을 하나로 묶음
	public void 회원가입(User user) {
		userRepository.save(user); // 트랜잭션
	}

	@Transactional(readOnly = true)
	public User 로그인(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()); // 트랜잭션
	}
}
