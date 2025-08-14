package com.talkster.post;

import com.talkster.auth.User;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

/*
 * Entry is the parent class of everything that can be posted (ie. Posts, Comments, Reposts).
 * To be clear, anything that can appear on the user page.
 */
@MappedSuperclass
public abstract class Entry {

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull
    private User author; 

    public Entry(){

    }

    public Entry(User author){
        this.author = author;
    }

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
}
