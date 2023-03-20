//package com.example.mydoc.services.impl;
//
//import com.example.mydoc.models.entities.User;
//import com.example.mydoc.repositories.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SecurityUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public SecurityUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = this.userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
//
//        return user;
//    }
//}
