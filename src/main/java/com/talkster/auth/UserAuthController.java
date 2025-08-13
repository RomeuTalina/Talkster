package com.talkster.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    private UserService userService; 

    public UserAuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/signup")
    public void create(@RequestParam String username, @RequestParam String password){
        System.out.println("Attempting to create user beep boop");
        userService.createUser(username, password); 
    }
}
