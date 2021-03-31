package com.piGL.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piGL.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

java.util.Optional<Comment>findByAnnoceId(Long annoceId );
	
	java.util.Optional<Comment> findByIdAndAnnoceId (Long id,Long annoceId) ;
	
	public List<Comment> findByDescription(String description);
}
