package com.talkster.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.talkster.post.Comment;
import com.talkster.post.CommentRepository;
import com.talkster.post.Post;
import com.talkster.post.PostRepository;

@Controller
public class PageController {

    PostRepository postRepository;
    CommentRepository commentRepository;

    public PageController(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){ 
        Iterable<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("posts", posts);
        return "dashboard";
    }
    
    @GetMapping("/signup")
    public String signup(){
      return "signup";
    }
    
    @GetMapping("/login") 
    public String login(){
      return "login";
    }

    @GetMapping("/post")
    public String post(){
        return "post";
    }
    
    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model){
        Post post = postRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid Post ID: " + id));
        List<Comment> comments = commentRepository.getCommentsByPost(post);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "viewPost";
    }
}
