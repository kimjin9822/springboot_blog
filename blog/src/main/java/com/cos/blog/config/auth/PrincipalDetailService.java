package com.cos.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service //Bean등록
public class PrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override //스프링이 로그인 가로챌때 username,password하는데 password는 알아서 처리함 username이 DB에 있는지 확인해주면
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {//여기서 username DB확인함
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당사용자를 찾을 수 없습니다. : "+username);
				});
		return new PrincipalDetail(principal);
	}
}
