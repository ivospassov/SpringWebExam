package com.example.mydoc.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {

    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });

        modelMapper.addConverter(new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(MappingContext<String, LocalTime> mappingContext) {
                return LocalTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("HH:mm"));
            }
        });

        return modelMapper;
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
