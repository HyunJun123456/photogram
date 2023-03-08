package com.cos.photogramstart.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
//	@Modifying // 내가 만든 쿼리에 대해서는 객체로 리턴이 안됨
//	@Query(value = "INSERT INTO comment(content, imageId, userId, createDate) VALUES(:content, :imageId, :userId, now())", nativeQuery = true)
//	Comment mSave(String content, int imageId, int userId);
	
	
}
