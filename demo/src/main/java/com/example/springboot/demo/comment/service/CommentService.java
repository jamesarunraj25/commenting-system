package com.example.springboot.demo.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.demo.comment.entity.CommentingSystemEntity;
import com.example.springboot.demo.comment.repository.CommentRepository;

import javassist.NotFoundException;

@Service
public class CommentService {
	@Autowired
	private CommentRepository dto;

	
	public List<CommentingSystemEntity> getAllComments() {
		return dto.findAll();
	}

	public CommentingSystemEntity getSelectedId(Long id) throws NotFoundException {
		return dto.findById(id).orElseThrow(() -> new NotFoundException(" No Such ID present in the Database"));
	}

	public CommentingSystemEntity saveToDb(CommentingSystemEntity comment) {
		return dto.save(comment);
	}
	
	
	
}