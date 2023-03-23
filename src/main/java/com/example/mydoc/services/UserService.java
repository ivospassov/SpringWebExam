package com.example.mydoc.services;

import com.example.mydoc.models.entities.User;

public interface UserService {

    User retrieveById(Long id);
}
