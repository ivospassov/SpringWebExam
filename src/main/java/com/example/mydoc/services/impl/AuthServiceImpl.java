package com.example.mydoc.services.impl;

import com.example.mydoc.models.dto.UserLoginDTO;
import com.example.mydoc.models.dto.UserRegisterDTO;
import com.example.mydoc.models.entities.User;
import com.example.mydoc.repositories.UserRepository;
import com.example.mydoc.services.AuthService;
import com.example.mydoc.web.session.UserLoginSession;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserLoginSession loginSession;

    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserLoginSession loginSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loginSession = loginSession;
    }

    @Override
    public boolean usernameExists(String username) {
        return this.userRepository.findByUsername(username).isPresent();
    }

    @Override
    public boolean emailExists(String email) {
        return this.userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean doPasswordsMatch(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User newUser = this.modelMapper.map(userRegisterDTO, User.class);

        //Encode password
        String encodedPass = this.passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPass);

        this.userRepository.save(newUser);
    }

    @Override
    public boolean userCredentialsAreValid(String username, String password) {
        Optional<User> user = this.findUser(username);

        return user.filter(value -> this.passwordEncoder.matches(password, value.getPassword())).isPresent();
    }

    @Override
    public void loginUser(UserLoginDTO userLoginDTO) {
        User user = this.findUser(userLoginDTO.getUsername()).get();
        this.loginSession.loginUser(user.getId(), user.getUsername());
    }

    @Override
    public void logoutUser() {
        this.loginSession.logoutUser();
    }

    private Optional<User> findUser(String username) {
        return this.userRepository.findByUsername(username);
    }
}
