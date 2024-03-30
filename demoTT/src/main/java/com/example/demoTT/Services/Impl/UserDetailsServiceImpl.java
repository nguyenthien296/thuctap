package com.example.demoTT.Services.Impl;

import com.example.demoTT.Models.Cinema;
import com.example.demoTT.Models.User;
import com.example.demoTT.Models.UserDetailsCustom;
import com.example.demoTT.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> findByUsername = userRepo.findByUserName(username);
        return new UserDetailsCustom(findByUsername.get());
    }

}
