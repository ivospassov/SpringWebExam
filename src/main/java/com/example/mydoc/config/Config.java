package com.example.mydoc.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config {

    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.authorizeHttpRequests()
//                .and().csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/home", "/users/logout").authenticated()
//                .requestMatchers("/gosho").hasRole("ADMIN")
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                .requestMatchers("/lib/bootstrap/**", "/css/**", "/img/**").permitAll()
//                .requestMatchers("/", "/users/login", "/users/register").permitAll()
//                .and().formLogin()
//                .loginPage("/users/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .failureForwardUrl("/users/login")
//                .successForwardUrl("/")
//                .and().logout().deleteCookies("JSESSIONID")
//                .and().httpBasic()
//                .and().build();
//    }
}
