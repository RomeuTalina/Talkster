package com.talkster.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talkster.auth.UserService;

@RestController
public class UserAuthController {

    private UserService userService; 

    public UserAuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signup")
    public void signup(@RequestParam String username, @RequestParam String password){
        userService.createUser(username, password); 
    }
}
