package com.cos.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //getter와 setter동시 사용
//@AllArgsConstructor//전체생성자
@NoArgsConstructor //빈생성자
public class Member {
	private int id; // final은 불변표시 변하지않을 값표현
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	

	
	
}