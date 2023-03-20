package com.example.mydoc.web.controller;

import com.example.mydoc.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    private final AuthService authService;

    public LogoutController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/users/logout")
    public String logoutUser() {
        this.authService.logoutUser();
        return "redirect:/";
    }
}
