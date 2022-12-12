package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //user 클래스가 MYSQL에 테이블이 생성
public class User {

	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 BD의 넘버링 전략을 따라간다.
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 100, unique = true)
	private String username; //아이디
	
	@Column(nullable = false, length = 100)
	private String password; //패스워드
	
	@Column(nullable = false, length = 50)
	private String email; // 이메일
	  
	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; 
	
	private String oauth; //kakao,google
	
	@CreationTimestamp //시간 자동 입력
	private Timestamp createDate;
	
}
