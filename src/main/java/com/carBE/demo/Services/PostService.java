package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.Post;

public interface PostService {
    Post createPost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
    //List<Post> getPostsByUser(Long userId);
}