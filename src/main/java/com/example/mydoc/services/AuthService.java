package com.example.mydoc.services;

import com.example.mydoc.models.dto.UserRegisterDTO;

public interface AuthService {

    boolean usernameExists(String username);

    boolean doPasswordsMatch(String password, String confirmPassword);

    void registerUser(UserRegisterDTO userRegisterDTO);

    boolean userCredentialsAreValid(String username, String password);
}
