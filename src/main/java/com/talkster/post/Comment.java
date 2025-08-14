package com.talkster.post;


import com.talkster.auth.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "comments")
public class Comment extends Entry{

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private Post post;

    @Column(nullable = false)
    @NotNull
    private String body;

    public Comment(Post post, User author, String body){
        super(author);
        this.post = post;
        this.body = body;
    } 

    public Comment(){

    }




	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public Post getPost() {
		return post;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPost(Post post) {
		this.post = post;
	} 
}
