package com.example.mydoc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/about-us")
    public String renderAboutUsPage() {

        return "/about-us";
    }
}
