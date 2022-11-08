package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	private String content; // 섬머노트 라이브러리 사용 -> html태그가 섞여서 디자인
	
	@ColumnDefault("0")
	private int count; //조회수
	
	@ManyToOne // many = board, one = user
	@JoinColumn(name = "userid")
	private User user; //DB는 오브젝트 저장 안됨      FK, 자바는 오브젝트 저장가능
	
	@CreationTimestamp
	private Timestamp createDate;
}
