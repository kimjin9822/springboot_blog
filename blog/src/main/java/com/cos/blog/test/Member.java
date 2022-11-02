package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //getter와 setter동시 사용
@AllArgsConstructor //전체생성자
@NoArgsConstructor //빈생성자
@Builder
public class Member {
	private int id; // final은 불변표시 변하지않을 값표현
	private String username;
	private String password;
	private String email;
	
}