package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.photogramstart.config.oauth.OAuth2DetailsService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final OAuth2DetailsService oAuth2DetailsService;
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super 삭제 - 기존 시큐리티가 가지고 있는 기능이 다 비활성화 됨.
		http.csrf().disable(); // csrf 비활성화 -> post 요청시 403이 안뜨게 해줌
		http.authorizeRequests()
			.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**", "/api/**").authenticated() // 인증이 필요
			.anyRequest().permitAll() // 모두 허용
			.and()
			.formLogin()
			.loginPage("/auth/signin") // 이쪽으로 자동으로 가게함. // GET
			.loginProcessingUrl("/auth/signin") // POST -> 스프링 시큐리티가 로그인 프로세스 진행
			.defaultSuccessUrl("/")
			.and()
			.oauth2Login() // form 로그인도 하는데, oauth2 로그인도 할꺼야!!
			.userInfoEndpoint() // oauth2 로그인을 하면 최종응답을 회원정보를 바로 받을 수 있다.
			.userService(oAuth2DetailsService);
		
	}
	
	
}
