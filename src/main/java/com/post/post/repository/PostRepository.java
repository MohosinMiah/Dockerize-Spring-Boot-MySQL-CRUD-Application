package com.post.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.post.entity.Post;

public interface PostRepository  extends JpaRepository<Post, Long> {
    
}
