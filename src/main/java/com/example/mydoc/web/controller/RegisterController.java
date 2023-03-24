package com.example.mydoc.web.controller;

import com.example.mydoc.models.dto.UserRegisterDTO;
import com.example.mydoc.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("registerDTO")
    public UserRegisterDTO registerDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping("/users/register")
    public String renderRegisterPage() {
        return "register";
    }

    @PostMapping("/users/register")
    public String handleRegisterForm(@Valid UserRegisterDTO registerDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("registerDTO", registerDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);

            return "redirect:/users/register";
        }


        //Check if username already exists
        boolean userExists = this.authService.usernameExists(registerDTO.getUsername());

        if (userExists) {
            redirectAttributes
                    .addFlashAttribute("usernameIsValid", false)
                    .addFlashAttribute("registerDTO", registerDTO);
            return "redirect:/users/register";
        }

        //Check if email exists already
        boolean emailExists = this.authService.emailExists(registerDTO.getEmail());
        if (emailExists) {
            redirectAttributes
                    .addFlashAttribute("registerDTO", registerDTO)
                    .addFlashAttribute("emailIsValid", false);

            return "redirect:/users/register";
        }

        //Check if passwords match
        boolean passwordsMatch = this.authService
                .doPasswordsMatch(registerDTO.getPassword(), registerDTO.getConfirmPassword());

        if (!passwordsMatch) {
            redirectAttributes
                    .addFlashAttribute("passwordsMatch", false)
                    .addFlashAttribute("registerDTO", registerDTO);

            return "redirect:/users/register";
        }

        //Otherwise register user and redirect to login page
        this.authService.registerUser(registerDTO);
        return "redirect:/users/login";
    }
}
