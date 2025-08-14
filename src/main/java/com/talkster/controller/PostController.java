package com.talkster.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.talkster.auth.User;
import com.talkster.auth.UserRepository;
import com.talkster.post.Comment;
import com.talkster.post.CommentDto;
import com.talkster.post.CommentRepository;
import com.talkster.post.Post;
import com.talkster.post.PostDto;
import com.talkster.post.PostRepository;


@RestController
public class PostController {

    PostRepository postRepository;
    CommentRepository commentRepository;
    UserRepository userRepository;

    public PostController(PostRepository postRepository, CommentRepository commentRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/api/post")
    public void createPost(@RequestBody PostDto postDto){
        User user = userRepository.getUserByUsername(postDto.getAuthorUsername());
        Post post = new Post(user, postDto.getBody());
        postRepository.save(post);
    }
    
    @PostMapping("/api/post/{id}/comment")
    public void createComment(@PathVariable Long id, @RequestBody CommentDto commentDto){
        Post post = postRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Post ID: "+ id));
        User user = userRepository.getUserByUsername(commentDto.getAuthorName());
        Comment comment = new Comment(post, user, commentDto.getBody());
        commentRepository.save(comment);
    }
}
