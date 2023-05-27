package com.post.post.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.post.post.payload.PostDto;

import jakarta.validation.Valid;


public interface PostService {

    PostDto createPost(@Valid PostDto postDto, HttpStatus created);

    List<PostDto> getAllPosts();

    PostDto getPostById(long postId);

    PostDto updatePost(@Valid PostDto postDto, long postId);

    void deletePostById(Long postId);


}
