package com.example.mydoc.web.controller;

import com.example.mydoc.models.entities.Hospital;
import com.example.mydoc.models.entities.MyDocDTO;
import com.example.mydoc.services.HospitalService;
import com.example.mydoc.services.MyDocService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class FindMyDocController {

    private final MyDocService myDocService;
    private final HospitalService hospitalService;

    public FindMyDocController(MyDocService myDocService, HospitalService hospitalService) {
        this.myDocService = myDocService;
        this.hospitalService = hospitalService;
    }

    @ModelAttribute("myDocDTO")
    public MyDocDTO myDocDTO() {
        return new MyDocDTO();
    }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/find-mydoc")
    public String handleFindMyDocForm(MyDocDTO myDocDTO) {

        Optional<Hospital> optionalHospital = hospitalService.findByName(myDocDTO.getHospital());
        boolean isFieldNotEmpty = myDocDTO.getHospital().length() != 0;

        if (optionalHospital.isEmpty() && isFieldNotEmpty) {
            //TODO: render custom 404 page
            return "/404Page";
        } else if (optionalHospital.isPresent() && isFieldNotEmpty) {
            return "redirect:/hospitals/" + optionalHospital.get().getId();
        }

        //TODO: Render by location and specialty
        return "redirect:/";
    }
}
