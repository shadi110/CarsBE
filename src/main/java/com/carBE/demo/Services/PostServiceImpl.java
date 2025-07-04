package com.carBE.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carBE.demo.PostRepository;
import com.carBE.demo.UserRepository;
import com.carBE.demo.dto.Post;
import com.carBE.demo.dto.User;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost != null) {
            existingPost.setText(post.getText());
            existingPost.setDate(post.getDate());
            existingPost.setNumberOfComments(post.getNumberOfComments());
            existingPost.setNumberOfReactions(post.getNumberOfReactions());
            existingPost.setImages(post.getImages());
            existingPost.setVideos(post.getVideos());
            return postRepository.save(existingPost);
        }
        return null;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    /*@Override
    public List<Post> getPostsByUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return postRepository.findByUser(user);
        }
        return null;
    }*/
}