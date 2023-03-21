package com.example.mydoc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorController {

    @GetMapping("/hospital/{id}/doctors")
    public String renderDoctorsFromHospital(@PathVariable Long id) {

        return "redirect:/doctors";
    }
}
