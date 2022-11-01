package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//사용자가 요청 -> data (응답)
@RestController
public class HttpControllerTest {

	@GetMapping("/http/get") //인터넷 브라우저 연결은 무조건 get요청밖에 할 수 없다.
	public String getTest(Member m) { //MessageConverter (스프링부트)
		return "get 요청: "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //MessageConverter (스프링부트)
		return "post 요청: "+m.getId() +","+m.getUsername()+","+m.getPassword()+","+m.getEmail();

	}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}

	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
