package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class BlogControllerTest {

@GetMapping("/test/hello")
	public String hello() {
		return "<h1>spring boot</h1>";
	}
}
