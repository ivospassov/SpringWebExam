package com.example.mydoc.web.controller;

import com.example.mydoc.models.dto.UserLoginDTO;
import com.example.mydoc.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }

    private final AuthService authService;

    @GetMapping("/users/login")
    public String renderLoginPage() {
        return "login";
    }

    @PostMapping("/users/login")
    public String handleLoginForm(@Valid UserLoginDTO userLoginDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult)
                    .addFlashAttribute("loginDTO", userLoginDTO);

            return "redirect:/users/login";
        }

        boolean isUserValid = this.authService.userCredentialsAreValid(userLoginDTO.getUsername(), userLoginDTO.getPassword());

        if (!isUserValid) {
            redirectAttributes
                    .addFlashAttribute("loginDTO", userLoginDTO)
                    .addFlashAttribute("userIsValid", false);

            return "redirect:/users/login";
        }

        //TODO: redirect to HOME page
        //TODO: Display 'Hello ${USER} alert message on display!'
        this.authService.loginUser(userLoginDTO);
        return "redirect:/";
    }
}
