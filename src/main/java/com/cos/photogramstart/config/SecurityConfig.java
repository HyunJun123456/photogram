package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super 삭제 - 기존 시큐리티가 가지고 있는 기능이 다 비활성화 됨.
		http.csrf().disable(); // csrf 비활성화 -> post 요청시 403이 안뜨게 해줌
		http.authorizeRequests()
			.antMatchers("/", "/users/**", "/image/**", "/subscribe/**", "/comment/**").authenticated() // 인증이 필요
			.anyRequest().permitAll() // 모두 허용
			.and()
			.formLogin()
			.loginPage("/auth/signin") // 이쪽으로 자동으로 가게함.
			.defaultSuccessUrl("/");
		
	}
	
	
}
