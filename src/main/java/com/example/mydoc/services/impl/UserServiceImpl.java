package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.User;
import com.example.mydoc.repositories.UserRepository;
import com.example.mydoc.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User retrieveById(Long id) {
        return this.userRepository.findById(id).get();
    }
}
