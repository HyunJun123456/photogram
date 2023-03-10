package com.cos.photogramstart.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // IoC
public class PrincipalDetailsService implements UserDetailsService{

	private final UserRepository userRepository;

	// 1. 패스워드는 알아서 체킹하니깐 신경 쓸 필요 없음
	// 2. 리턴이 잘되면 자동으로 UserDetails 타입을 세션으로 만듦
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = userRepository.findByUsername(username);
		if(userEntity == null) {
			return null;
		}else {
			return new PrincipalDetails(userEntity);
		}
	}

}
/*
 * 이미 IoC에 UserDetailsService가 띄워져 있음
 * PrincipalDetailsService가 UserDetailsService와 타입이 같아서 덮어 씌워짐
 * 부품을 갈아끼운 상태임
 * 
 * */
 