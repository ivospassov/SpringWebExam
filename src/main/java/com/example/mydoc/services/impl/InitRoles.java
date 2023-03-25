package com.example.mydoc.services.impl;

import com.example.mydoc.models.entities.User;
import com.example.mydoc.models.entities.UserRole;
import com.example.mydoc.models.enums.UserRoleEnum;
import com.example.mydoc.repositories.UserRepository;
import com.example.mydoc.repositories.UserRoleRepository;
import com.example.mydoc.services.InitService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitRoles implements InitService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public InitRoles(UserRoleRepository userRoleRepository,
                     UserRepository userRepository,
                     PasswordEncoder passwordEncoder,
                     @Value("${app.default.password}") String defaultPassword) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Override
    public void init() {
        initRoles();
        initAdmin();
    }

    private void initAdmin() {

        if (this.userRepository.findByUsername("IvoSpassov").isEmpty()) {
            User admin = new User();
            admin.setEmail("admin@example.com");
            admin.setUsername("IvoSpassov");
            admin.setPassword(this.passwordEncoder.encode("secret"));
            admin.setUserRoles(this.userRoleRepository.findAll());

            this.userRepository.save(admin);
        }
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setRole(UserRoleEnum.ADMIN);

            this.userRoleRepository.save(adminRole);
        }
    }
}
