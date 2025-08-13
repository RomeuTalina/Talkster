package com.talkster.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired 
    private UserRepository userRepository;

    @Autowired 
    private BCryptPasswordEncoder passwordEncoder;

    public void createUser(String username, String rawPassword){

        User newUser = new User();

        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(rawPassword));
        newUser.setRole("ROLE_USER");
        newUser.setEnabled(true);
        userRepository.save(newUser);
    } 
}
