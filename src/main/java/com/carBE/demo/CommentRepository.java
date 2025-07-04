package com.carBE.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carBE.demo.dto.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}