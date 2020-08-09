package com.example.springboot.demo.comment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.demo.comment.entity.CommentingSystemEntity;
import com.example.springboot.demo.comment.repository.CommentRepository;
import com.example.springboot.demo.comment.service.CommentService;

import javassist.NotFoundException;

import java.util.List;


@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentRepository dto;
	
    @RequestMapping("/")
    public String index() {
        return "New Commenting System";
    }
    
    @GetMapping("/allcomments")
	public List<CommentingSystemEntity> getAllComment() {
    	return commentService.getAllComments();
	}
	
    @GetMapping("/{id}")
    public CommentingSystemEntity getSelectedId(@PathVariable("id") Long id) throws NotFoundException {
    	return commentService.getSelectedId(id);
    }
    
    @PostMapping("/createcomment")
	public CommentingSystemEntity postParentComment(@Validated @RequestBody CommentingSystemEntity comment) throws NotFoundException {
    	if(comment.getPostcomment()== null || comment.getPostcomment().equals("")) {
    		throw new NotFoundException("ID should not be empty");
    	}
    	return commentService.saveToDb(comment);
	}
    
    @PostMapping("/createreply/{id}")
  	public CommentingSystemEntity postComment(@PathVariable Long id,@RequestBody CommentingSystemEntity comment) throws NotFoundException {
    	return dto.findById(id).map(parent->{
    		comment.setReply(parent);
    		return dto.save(comment);
    	}).orElseThrow(() -> new NotFoundException(" No Such ID present in the Database"));
    }
}