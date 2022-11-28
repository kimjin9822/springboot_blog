package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;

@Service // 스프링이 컴포넌트 스캔을 통해 Bean 등록, IOC해줌
public class BoardService { // 서비스 필요이유 : 여러개의 트랜잭션 관리,

	@Autowired
	private BoardRepository boardRepository;

	@Transactional // 전체 트랙잭션을 하나로 묶음
	public void 글쓰기(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
}
