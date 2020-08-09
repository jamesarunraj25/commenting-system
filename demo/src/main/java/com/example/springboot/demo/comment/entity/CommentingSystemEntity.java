package com.example.springboot.demo.comment.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="COMMENTINGS")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1)
public class CommentingSystemEntity { 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String postcomment;

    @ManyToOne
    @JoinColumn(name="REPLY")
    @JsonBackReference
    @Getter
    @Setter
    private CommentingSystemEntity reply;

    @OneToMany(mappedBy = "reply")
    @JsonManagedReference
    @Getter
    @Setter
    private Set<CommentingSystemEntity> postreply;

   }