package com.carBE.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carBE.demo.CommentRepository;
import com.carBE.demo.PostRepository;
import com.carBE.demo.UserRepository;
import com.carBE.demo.dto.Comment;
import com.carBE.demo.dto.Post;
import com.carBE.demo.dto.User;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Long id, Comment comment) {
        Comment existingComment = commentRepository.findById(id).orElse(null);
        if (existingComment != null) {
            existingComment.setText(comment.getText());
            existingComment.setDate(comment.getDate());
            existingComment.setImages(comment.getImages());
            existingComment.setVideos(comment.getVideos());
            return commentRepository.save(existingComment);
        }
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    /*@Override
    public List<Comment> getCommentsByPost(Long postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post != null) {
            return commentRepository.findByPost(post);
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return commentRepository.findByUser(user);
        }
        return null;
    }*/
}