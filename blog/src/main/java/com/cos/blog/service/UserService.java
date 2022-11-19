package com.cos.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해 Bean 등록, IOC해줌
public class UserService { // 서비스 필요이유 : 여러개의 트랜잭션 관리, 

	@Autowired
	private UserRepository userRepository;

	@Transactional //전체 트랙잭션을 하나로 묶음
	public int 회원가입(User user) {
		try {
			userRepository.save(user); // 트랜잭션 
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() : " + e.getMessage());
		}
		return -1;
	}
}
