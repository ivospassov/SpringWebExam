package com.example.webexam.service;

import com.example.webexam.model.entity.UserEntity;
import com.example.webexam.model.entity.UserRoleEntity;
import com.example.webexam.model.enums.UserRoleEnum;
import com.example.webexam.repository.UserRepository;
import com.example.webexam.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitService {

  private final UserRoleRepository userRoleRepository;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public InitService(UserRoleRepository userRoleRepository,
      UserRepository userRepository,
      PasswordEncoder passwordEncoder,
      @Value("${app.default.password}") String defaultPassword) {
    this.userRoleRepository = userRoleRepository;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostConstruct
  public void init() {
    initRoles();
    initUsers();
  }

  private void initRoles() {
    if (userRoleRepository.count() == 0) {
      var moderatorRole = new UserRoleEntity().setRole(UserRoleEnum.MODERATOR);
      var adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);

      userRoleRepository.save(moderatorRole);
      userRoleRepository.save(adminRole);
    }
  }

  private void initUsers() {
    if (userRepository.count() == 0) {
      initAdmin();
      initModerator();
      initNormalUser();
    }
  }

  private void initAdmin(){
    var adminUser = new UserEntity().
        setEmail("admin@example.com").
        setFirstName("Admin").
        setLastName("Adminov").
        setCountry("Bulgaria").
        setPassword(passwordEncoder.encode("topsecret")).
        setRoles(userRoleRepository.findAll());

    userRepository.save(adminUser);
  }

  private void initModerator(){

    var moderatorRole = userRoleRepository.
        findUserRoleEntityByRole(UserRoleEnum.MODERATOR).orElseThrow();

    var moderatorUser = new UserEntity().
        setEmail("moderator@example.com").
        setFirstName("Moderator").
        setLastName("Moderatorov").
        setCountry("Greece").
        setPassword(passwordEncoder.encode("topsecret")).
        setRoles(List.of(moderatorRole));

    userRepository.save(moderatorUser);
  }

  private void initNormalUser(){

    var normalUser = new UserEntity().
        setEmail("user@example.com").
        setFirstName("User").
        setLastName("Userov").
        setCountry("Tanzania").
        setPassword(passwordEncoder.encode("topsecret"));

    userRepository.save(normalUser);
  }
}
