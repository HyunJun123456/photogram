package com.cos.photogramstart.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service // IoC
public class PrincipalDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("나 실행돼?"+username);
		return null;
	}

}
/*
 * 이미 IoC에 UserDetailsService가 띄워져 있음
 * PrincipalDetailsService가 UserDetailsService와 타입이 같아서 덮어 씌워짐
 * 부품을 갈아끼운 상태임
 * 
 * */
 