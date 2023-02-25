package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
// 어노테이션이 없어도 JpaRepository를 상속하면 IoC 등록이 자동으로 된다.
public interface UserRepository extends JpaRepository<User, Integer>{ // User Entity의 ID가 int 타입임
	// JPA query methods
	User findByUsername(String username);
}
