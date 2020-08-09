package com.example.springboot.demo.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.demo.comment.entity.CommentingSystemEntity;





@Repository
public interface CommentRepository extends JpaRepository<CommentingSystemEntity, Long> {
}