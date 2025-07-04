package com.carBE.demo.Services;

import java.util.List;

import com.carBE.demo.dto.Comment;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment getCommentById(Long id);
    List<Comment> getAllComments();
    Comment updateComment(Long id, Comment comment);
    void deleteComment(Long id);
    //List<Comment> getCommentsByPost(Long postId);
    //List<Comment> getCommentsByUser(Long userId);
}