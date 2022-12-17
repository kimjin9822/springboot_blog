package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.Board;
import com.cos.blog.model.Reply;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.ReplyRepository;

@Service // 스프링이 컴포넌트 스캔을 통해 Bean 등록, IOC해줌
public class BoardService { // 서비스 필요이유 : 여러개의 트랜잭션 관리,

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;

	@Transactional // 전체 트랙잭션을 하나로 묶음
	public void 글쓰기(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()-> {
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()-> {
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
				}); //영속화
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	} //해당 함수 종료시 트랜잭션이 종료됨 이때 더티체킹이 일어남(자동 업데이트)
	
	@Transactional
	public void 댓글쓰기(User user, int boardid , Reply requestReply) {
		
		Board board = boardRepository.findById(boardid).orElseThrow(()->{
			return new IllegalArgumentException("댓글 쓰기 실패 : 계시글 id를 찾을 수 없습니다.");
		});
		
		requestReply.setUser(user);
		requestReply.setBoard(board);
		
		replyRepository.save(requestReply);
	}
}
