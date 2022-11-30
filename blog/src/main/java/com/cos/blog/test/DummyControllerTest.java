package com.cos.blog.test;


import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;


@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional // 더티체킹 (save안해도 업데이트가능하며 함수종료시 자동 commit (변경감지 -> DB수정))
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requsetUser) {
		System.out.println("id : "+id);
		System.out.println("password : "+requsetUser.getPassword());
		System.out.println("email : "+requsetUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requsetUser.getPassword());
		user.setEmail(requsetUser.getEmail());
		return user;
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
		}
		return "삭제되었습니다. id : "+id;
	}
	
	
	// 전체 검색
	@GetMapping("/dummy/user")
	public List<User> list(){
		return userRepository.findAll();
}
	//한페이지당 2건의 데이터를 리턴
	@GetMapping("/dummy/user/page")
	public Page<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC) Pageable pageable){
		Page<User> pagingUser =  userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return pagingUser;
	}
	
	//1개 리턴
	@GetMapping("/dummy/user/{id}")
	public User Detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>(){
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다 id : "+id);
			}
		});
		return user;
	}
	
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id: "+user.getId());
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		System.out.println("role: "+user.getRole());
		System.out.println("createDate: "+user.getCreateDate());

		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "더미 테이블";
	}
}
