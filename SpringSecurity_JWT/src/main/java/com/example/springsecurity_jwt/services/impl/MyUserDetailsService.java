package com.example.springsecurity_jwt.services.impl;

import com.example.springsecurity_jwt.dao.User;
import com.example.springsecurity_jwt.exception.NotFoundException;
import com.example.springsecurity_jwt.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService  {
    @Autowired
    private IUserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new NotFoundException("Username " + username + " does not exist.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), null);

    }
}
