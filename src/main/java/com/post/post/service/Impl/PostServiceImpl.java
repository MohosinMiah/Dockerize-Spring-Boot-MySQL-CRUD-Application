package com.post.post.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.post.post.entity.Post;
import com.post.post.exception.ResourceNotFoundException;
import com.post.post.payload.PostDto;
import com.post.post.repository.PostRepository;
import com.post.post.service.PostService;

import jakarta.validation.Valid;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public PostDto createPost(@Valid PostDto postDto, HttpStatus created) {
        
        // convert DTO to entity
        Post newPost = mapToEntity(postDto);

        postRepository.save(newPost);
         // convert entity to DTO
         PostDto postResponse = mapToDTO(newPost);
         return postResponse;

    }




    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts =  postRepository.findAll();
         // convert entity to DTO
         List<PostDto> postList = posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        
         return postList;
    }



    @Override
    public PostDto getPostById(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        return mapToDTO(post);
    }


    @Override
    public PostDto updatePost(PostDto postDto, long postId) {
        // get post by id from the database
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

     
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return mapToDTO(updatedPost);
    }
    
    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
        
    }

     // convert Entity into DTO
     private PostDto mapToDTO(Post post){
        PostDto postDto = mapper.map(post, PostDto.class);
//        PostDto postDto = new PostDto();
//        postDto.setId(post.getId());
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());
        return postDto;
    }

    // convert DTO to entity
    private Post mapToEntity(PostDto postDto){
        Post post = mapper.map(postDto, Post.class);
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        return post;
    }

    
}
