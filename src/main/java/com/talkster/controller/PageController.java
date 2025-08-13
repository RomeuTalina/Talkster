package com.talkster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/dashboard")
    public String dashboard(){
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
}
