package com.example.webexam.web;

import com.example.webexam.model.AppUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasePageController {

  @GetMapping("/")
  public String renderHomePage(@AuthenticationPrincipal AppUserDetails appUserDetails, Model model) {

    if (appUserDetails != null) {
      model.addAttribute("fullName", appUserDetails.getFullName());
      model.addAttribute("city", appUserDetails.getCity());
    }

    return "index";
  }

  @GetMapping("/pages/all")
  public String all() {
    return "all";
  }

  @GetMapping("/pages/admins")
  public String admins() {
    return "admins";
  }

  @GetMapping("/pages/moderators")
  public String moderators() {
    return "moderators";
  }
}
