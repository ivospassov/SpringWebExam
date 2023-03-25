//package com.example.mydoc.services.impl;
//
//import com.example.mydoc.models.entities.User;
//import com.example.mydoc.models.entities.UserRole;
//import com.example.mydoc.repositories.UserRepository;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ApplicationUserDetailsService  implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public ApplicationUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return
//                userRepository
//                        .findByUsername(username)
//                        .map(this::map)
//                        .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
//    }
//
//    private UserDetails map(User user) {
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                extractAuthorities(user)
//        );
//    }
//
//    private List<GrantedAuthority> extractAuthorities(User user) {
//        return user.
//                getUserRoles().
//                stream().
//                map(this::mapRole).
//                toList();
//    }
//
//    private GrantedAuthority mapRole(UserRole userRole) {
//        return new SimpleGrantedAuthority("ROLE_" + userRole.getRole().name());
//    }
//
//}
